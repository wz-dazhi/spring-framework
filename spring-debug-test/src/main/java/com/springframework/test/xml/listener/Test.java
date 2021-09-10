package com.springframework.test.xml.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.listener
 * @className: Test
 * @description:
 * @author: zhi
 * @date: 2021/9/9
 * @version: 1.0
 */
public class Test {
	public static void main(String[] args) {
		//System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/wangzhi/work/project/spring-framework/spring-debug-test/src/main/java/com/springframework/test/xml/listener");
		ApplicationContext c = new ClassPathXmlApplicationContext("listener/listener.xml");
		UserService userService = c.getBean(UserService.class);
		userService.createUser("1", "张三");
	}
}
