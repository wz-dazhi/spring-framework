package com.springframework.test.xml;

import com.springframework.test.xml.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test
 * @className: XmlTest
 * @description:
 * @author: zhi
 * @date: 2021/7/6
 * @version: 1.0
 */
public class XmlTest {

	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("xml/applicationContext.xml");
		// ApplicationContext c = new ClassPathXmlApplicationContext("xml/application-${user.name}.xml");
		// ApplicationContext c = new MyClassPathXmlApplicationContext("xml/application-${user.name${user.language}}.xml");
		final User u = c.getBean(User.class);
		System.out.println(u);
	}
}
