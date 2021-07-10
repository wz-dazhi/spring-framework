package com.springframework.test.groovy;

import org.springframework.context.ApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.groovy
 * @className: GroovyTest
 * @description:
 * @author: zhi
 * @date: 2021/7/7
 * @version: 1.0
 */
public class GroovyTest {

	public static void main(String[] args) {
		ApplicationContext c = new ClassPathGroovyApplicationContext("groovy/applicationContext.groovy");
		final User u = c.getBean(User.class);
		System.out.println(u);
	}
}
