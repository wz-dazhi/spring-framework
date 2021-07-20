package com.springframework.test.xml.beanfactorypostprocessor;

import com.springframework.test.xml.bean.User;
import com.springframework.test.xml.context.MyClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.beanfactorypostprocessor
 * @className: BFPPTest
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class BFPPTest {
	public static void main(String[] args) {
		ApplicationContext c = new MyClassPathXmlApplicationContext("xml/applicationContext.xml");
		final User u = c.getBean("user", User.class);
		System.out.println(u);
		System.out.println("---");
		System.out.println(c.getBean("u2", User.class));
	}
}
