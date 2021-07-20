package com.springframework.test.xml.supplier;

import com.springframework.test.xml.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.supplier
 * @className: SupplierTest
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class SupplierTest {

	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("xml/supplier.xml");
		final User u = c.getBean(User.class);
		System.out.println(u);
	}
}
