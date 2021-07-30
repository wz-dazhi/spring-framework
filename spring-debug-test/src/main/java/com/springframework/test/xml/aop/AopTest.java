package com.springframework.test.xml.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml
 * @className: AopTest
 * @description:
 * @author: zhi
 * @date: 2021/7/27
 * @version: 1.0
 */
public class AopTest {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("aop/aop.xml");
		final UserService u = c.getBean(UserService.class);
		System.out.println(u.getClass());
		u.show();
	}
}
