package com.springframework.test.xml.customeditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.customeditor
 * @className: EditorTest
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class EditorTest {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("editor/editor.xml");
		final User u = c.getBean(User.class);
		System.out.println(u);
	}
}
