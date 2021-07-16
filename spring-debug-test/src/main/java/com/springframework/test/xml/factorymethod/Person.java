package com.springframework.test.xml.factorymethod;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.factorymethod
 * @className: Person
 * @description:
 * @author: zhi
 * @date: 2021/7/16
 * @version: 1.0
 */
public class Person {
	private String username;

	public Person() {
	}

	public Person(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Person{" +
				"username='" + username + '\'' +
				'}';
	}
}
