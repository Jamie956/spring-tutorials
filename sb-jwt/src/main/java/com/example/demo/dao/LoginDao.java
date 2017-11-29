package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.JwtUser;

@Repository
public class LoginDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private static final RowMapper<JwtUser> itemsMapper = new RowMapper<JwtUser>() {
		public JwtUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			JwtUser item = new JwtUser();
			item.setUserName(rs.getString("email"));
			return item;
		}
	};

	public boolean login(JwtUser jwtUser) {
		String _user_name = jwtUser.getUserName();
		String _password = jwtUser.getPassword();
		String _sql = "SELECT email FROM t_merchant WHERE email = '" +_user_name+ "' AND password = '" +_password+ "' ";
		System.out.println("_sql => "+_sql);
		List<?> items = jdbcTemplate.query(_sql, itemsMapper);
		boolean result = ( items.size() > 0 ) ? true : false;
		return result;
	}
	
}
