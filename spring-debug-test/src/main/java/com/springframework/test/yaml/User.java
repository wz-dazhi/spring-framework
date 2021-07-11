package com.springframework.test.yaml;

/**
 * @projectName: spring
 * @package: com.springframework.test.yaml
 * @className: User
 * @description:
 * @author: zhi
 * @date: 2021/7/11
 * @version: 1.0
 */
public class User {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
