package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.JwtUser;

@Repository
public class LoginService {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	
	private static final RowMapper<JwtUser> itemsMapper = new RowMapper<JwtUser>() {
		public JwtUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			JwtUser item = new JwtUser();
			item.setUserName(rs.getString("email"));
			return item;
		}
	};
	
	
	 public JwtUser login(JwtUser jwtUser) {
			String _sql = "SELECT email FROM t_merchant WHERE email = '" +jwtUser.getUserName()+ "'  ";
			
			System.out.println(_sql);
			
			List<JwtUser> items = jdbcTemplate.query(_sql, itemsMapper);
			
			JwtUser result = null;
			result = items.get(0); 		        
		        
	        return result;
	    }	
}
