package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	@Autowired
	@Qualifier("hikariJdbcTemplate")
	protected JdbcTemplate hikariJdbcTemplate;

	private UserRowMapper userMapper = new UserRowMapper();

	public void save(User user) {
		String sql = "INSERT INTO t_user (id, name, password) VALUES (null, ?, ?)";
		Object[] values = { user.getName(), user.getPassword() };
		hikariJdbcTemplate.update(sql, values);
	}

	public List<User> findAll() {
		String sql = "SELECT id, name, password FROM t_user";
		List<User> users = hikariJdbcTemplate.query(sql, userMapper);
		return users;
	}

	public User findAllById(Integer id) {
		String sql = "SELECT id, name, password FROM t_user WHERE id = ?";
		User user = hikariJdbcTemplate.queryForObject(sql, userMapper, id);
		return user;
	}

}
