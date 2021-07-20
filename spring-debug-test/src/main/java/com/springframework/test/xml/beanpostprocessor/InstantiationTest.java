package com.springframework.test.xml.beanpostprocessor;

import com.springframework.test.xml.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.beanpostprocessor
 * @className: InstantiationTest
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class InstantiationTest {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("xml/instantiation.xml");
		final User u = c.getBean(User.class);
		System.out.println(u);
	}
}
