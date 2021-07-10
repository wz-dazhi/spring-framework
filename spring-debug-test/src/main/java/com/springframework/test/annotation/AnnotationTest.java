package com.springframework.test.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @projectName: spring
 * @package: com.springframework
 * @className: test
 * @description:
 * @author: zhi
 * @date: 2021/7/4
 * @version: 1.0
 */
public class AnnotationTest {

	public static void main(String[] args) {
		ApplicationContext c = new AnnotationConfigApplicationContext("com.springframework.test.annotation");
		final Environment e = c.getEnvironment();
		System.out.println(e.getProperty("user.home"));
	}
}
