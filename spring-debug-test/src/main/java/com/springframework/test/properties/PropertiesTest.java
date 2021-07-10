package com.springframework.test.properties;

import org.springframework.context.ApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.properties
 * @className: PropertiesTest
 * @description:
 * @author: zhi
 * @date: 2021/7/7
 * @version: 1.0
 */
public class PropertiesTest {

	public static void main(String[] args) {
		ApplicationContext c = new ClassPathPropertiesApplicationContext("properties/applicationContext.properties");
		final User u = c.getBean(User.class);
		System.out.println(u);
	}
}
