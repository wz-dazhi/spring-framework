package com.springframework.test.xml.aop.jdk;

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
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		ApplicationContext c = new ClassPathXmlApplicationContext("aop/aop-jdk.xml");
		final IUserService u = c.getBean(IUserService.class);
		System.out.println(u);
		System.out.println(u.getClass());
		u.show("zhangsan");
		//u.show2("show2");
	}
}
