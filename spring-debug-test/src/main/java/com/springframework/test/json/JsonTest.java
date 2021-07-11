package com.springframework.test.json;

import org.springframework.context.ApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.json
 * @className: JsonTest
 * @description:
 * @author: zhi
 * @date: 2021/7/10
 * @version: 1.0
 */
public class JsonTest {

	public static void main(String[] args) {
		ApplicationContext c = new ClassPathJsonApplicationContext("json/applicationContext.json");
		final User u = c.getBean(User.class);
		System.out.println(u);
	}
}
