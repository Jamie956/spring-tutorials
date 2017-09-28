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

import com.example.demo.domain.Product;


@Repository
public class ProductService {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
    @Autowired
    private RedisTemplate redisTemplate;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    
	private static final RowMapper<Product> itemsMapper = new RowMapper<Product>() {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product item = new Product();
			
//			private String productCode;
//			private String productName;
//			private String productLine;
//			private String productScale;
//			private String productVendor;
//			private String productDescription;
//			private String quantityInStock;
//			private String buyPrice;
//			private String MSRP;
			
			item.setProductCode(rs.getString("productCode"));
			item.setProductName(rs.getString("productName"));
			
			return item;
		}
	};
	
    public Product findProductById(String id) {
        String key = "product_" + id;
        ValueOperations<String, Product> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        
        if (hasKey) {
        	Product product = operations.get(key);
            LOGGER.info("ProductService.findProductById() : get product from cache -> " + product.toString());
            return product;
        }
		String _sql = "SELECT productCode, productName FROM products WHERE productCode = '" +id+ "' ";
		List<Product> items = jdbcTemplate.query(_sql, itemsMapper);
		
		Product product = items.get(0); 
        operations.set(key, product, 60, TimeUnit.SECONDS);
        LOGGER.info("ProductService.findProductById() : product add to cache -> " + product.toString());

        return product;
    }
	
}
