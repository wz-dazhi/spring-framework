package com.springframework.test.xml.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.annotation
 * @className: AnnotationTest
 * @description:
 * @author: zhi
 * @date: 2021/7/21
 * @version: 1.0
 */
public class AnnotationTest {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("xml/annotation.xml");
		final UserController con = c.getBean(UserController.class);
		con.show();
	}
}
