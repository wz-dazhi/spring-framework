package com.springframework.test.xml.bean;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.bean
 * @className: User
 * @description:
 * @author: zhi
 * @date: 2021/7/6
 * @version: 1.0
 */
public class User {
	private String name;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				'}';
	}
}
