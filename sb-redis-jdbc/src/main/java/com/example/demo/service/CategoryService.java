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
			item.setOriginal_id(rs.getString("original_id"));
			item.setName(rs.getString("name"));
			item.setMerchant_id(rs.getString("merchant_id"));
			item.setCategory_ufo(rs.getString("category_ufo"));
			item.setScript(rs.getString("script"));
			item.setCreated_time(rs.getString("created_time"));
			item.setUpdated_time(rs.getString("updated_time"));
			item.setAlcohol(rs.getString("alcohol"));
			item.setHidden(rs.getString("hidden"));
			item.setFlag(rs.getString("flag"));
			item.setDisplay_name(rs.getString("display_name"));
			return item;
		}
	};
	
    public Category findCategoryById(String id) {
        String key = "category_" + id;
        ValueOperations<String, Category> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        
        if (hasKey) {
        	Category category = operations.get(key);
            LOGGER.info("get category from cache -> " + category.toString());
            return category;
        }
		String _sql = "SELECT * FROM t_category WHERE id = '" +id+ "' ";
		List<Category> items = jdbcTemplate.query(_sql, itemsMapper);
		
		Category category = items.get(0); 
        operations.set(key, category, 60, TimeUnit.SECONDS);
        LOGGER.info("category add to cache -> " + category.toString());

        return category;
    }
    
    public int saveCategory(Category category) {
    	
    	String _id = category.getId();
    	String _original_id = category.getOriginal_id();
    	String _name = category.getName();
    	String _merchant_id = category.getMerchant_id();
    	String _category_ufo = category.getCategory_ufo();
    	String _script = category.getScript();
    	String _created_time = category.getCreated_time();
    	String _updated_time = category.getUpdated_time();
    	String _alcohol = category.getAlcohol();
    	String _hidden = category.getHidden();
    	String _flag = category.getFlag();
    	String _display_name = category.getDisplay_name();
    	
		String _sql = "INSERT INTO t_category VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		Object[] _val = { _id, _original_id, _name, _merchant_id, _category_ufo,
				_script, _created_time, _updated_time, _alcohol, _hidden, _flag, _display_name };
		
		int count = jdbcTemplate.update(_sql, _val);
		return count;
    }
    
    public int updateCategory(Category category) {
    	
    	String _id = category.getId();
    	String _original_id = category.getOriginal_id();
    	String _name = category.getName();
    	String _merchant_id = category.getMerchant_id();
    	String _category_ufo = category.getCategory_ufo();
    	String _script = category.getScript();
    	String _created_time = category.getCreated_time();
    	String _updated_time = category.getUpdated_time();
    	String _alcohol = category.getAlcohol();
    	String _hidden = category.getHidden();
    	String _flag = category.getFlag();
    	String _display_name = category.getDisplay_name();
    	
		String _sql = "UPDATE t_category set name = ? where id = ?";
		Object[] _val = {_name, _id};
		
		int count = jdbcTemplate.update(_sql, _val);
        
        String key = "category_" + _id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("remove category from cache -> " + category.toString());
        }

        return count;
    }
    
    
    public int removeCategory(String id) {
		String _sql = " UPDATE t_category SET flag = 1 WHERE id = ?";
		Object[] _val = {id};
		int count = jdbcTemplate.update(_sql, _val);
    		
        String key = "category_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("remove category from cache -> " + id);
        }
        return count;
    }
    
	
}
