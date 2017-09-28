package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Category;

@Repository
public class CategoryService {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
    @Autowired
    private RedisTemplate redisTemplate;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);
    
	private static final RowMapper<Category> itemsMapper = new RowMapper<Category>() {
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category item = new Category();
			item.setId(rs.getString("id"));
			item.setName(rs.getString("name"));
			item.setCreatedTime(rs.getString("created_time"));
			item.setUpdatedTime(rs.getString("updated_time"));
			item.setCategoryUfo(rs.getString("category_ufo"));
			item.setAlcohol(rs.getString("alcohol"));
			item.setDisplayName(rs.getString("display_name"));
			return item;
		}
	};
	
    public Category findCategoryById(String id) {
        String key = "city_" + id;
        ValueOperations<String, Category> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        
        if (hasKey) {
        	Category category = operations.get(key);
        	
            LOGGER.info("CategoryService.findCategoryById() : get category from cache -> " + category.toString());
            return category;
        }

		String _sql = "SELECT id, name, created_time, updated_time, category_ufo, alcohol,"
				+ " display_name FROM t_category WHERE id = '" +id+ "' ";
		List<Category> items = jdbcTemplate.query(_sql, itemsMapper);
		
		Category category = items.get(0); 
        operations.set(key, category, 60, TimeUnit.SECONDS);
        LOGGER.info("CategoryService.findCategoryById() : category add to cache -> " + category.toString());

        return category;
    }
	
	
}
