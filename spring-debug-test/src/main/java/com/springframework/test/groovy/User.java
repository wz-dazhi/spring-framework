package com.springframework.test.groovy;

/**
 * @projectName: spring
 * @package: com.springframework.test.properties
 * @className: User
 * @description:
 * @author: zhi
 * @date: 2021/7/7
 * @version: 1.0
 */
public class User {
	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
