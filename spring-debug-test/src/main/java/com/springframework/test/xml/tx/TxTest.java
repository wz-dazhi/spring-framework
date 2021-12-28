package com.springframework.test.xml.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.tx
 * @className: TxTest
 * @description:
 * @author: zhi
 * @date: 2021/12/28
 * @version: 1.0
 */
public class TxTest {

	private static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'h', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z'};
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("xml/tx.xml");
		UserService userService = ac.getBean(UserService.class);
		List<User> users = userService.getAll();
		users.forEach(System.out::println);
		System.out.println("-----------------");
		User u = userService.getById(1L);
		System.out.println(u);
		System.out.println("-----------------");
		u.setUserNo(random());
		u.setUsername(random());
		u.setPassword(random());
		u.setCreateTime(LocalDateTime.now());
		u.setUpdateTime(LocalDateTime.now());
		System.out.println(userService.add(u));
	}

	private static String random() {
		StringBuilder random = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			random.append(CHARS[RANDOM.nextInt(CHARS.length)]);
		}
		return random.toString();
	}
}
