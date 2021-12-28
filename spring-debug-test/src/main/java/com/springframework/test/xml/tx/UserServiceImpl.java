package com.springframework.test.xml.tx;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.tx
 * @className: UserServiceImpl
 * @description:
 * @author: zhi
 * @date: 2021/12/28
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {
	private final JdbcTemplate jdbcTemplate;

	public UserServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM t_user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
	}

	@Override
	public int add(User u) {
		return jdbcTemplate.update("insert into t_user(user_no, username, password, create_time, update_time) VALUES (?, ?, ?, ?, ?)",
				u.getUserNo(), u.getUsername(), u.getPassword(), u.getCreateTime(), u.getUpdateTime());
	}

	@Override
	public List<User> getAll() {
		return jdbcTemplate.query("SELECT * FROM t_user", new BeanPropertyRowMapper<>(User.class));
	}
}
