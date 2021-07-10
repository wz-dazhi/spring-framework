package com.springframework.test.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.tag
 * @className: TagTest
 * @description:
 * @author: zhi
 * @date: 2021/7/6
 * @version: 1.0
 */
public class TagTest {

	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("tag/applicationContext.xml");
		final DazhiTag tag = c.getBean("daZhiTag", DazhiTag.class);
		System.out.println(tag);
	}
}
