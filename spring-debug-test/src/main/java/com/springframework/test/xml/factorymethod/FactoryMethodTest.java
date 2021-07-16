package com.springframework.test.xml.factorymethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.factorymethod
 * @className: FactoryMethodTest
 * @description:
 * @author: zhi
 * @date: 2021/7/16
 * @version: 1.0
 */
public class FactoryMethodTest {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("xml/factory-method.xml");
		final Person p1 = c.getBean("person", Person.class);
		System.out.println(p1);
		final Person p2 = c.getBean("person2", Person.class);
		System.out.println(p2);
	}
}
