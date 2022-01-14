package com.webflux.test.bean;

/**
 * @projectName: spring
 * @package: com.webflux.test.bean
 * @className: User
 * @description:
 * @author: zhi
 * @date: 2022/1/14
 * @version: 1.0
 */
public class User {
	private String username;
	private String password;
	private int age;

	public User() {
	}

	public User(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				'}';
	}
}
