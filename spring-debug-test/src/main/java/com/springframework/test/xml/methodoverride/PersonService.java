package com.springframework.test.xml.methodoverride;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.methodoverride
 * @className: PersonService
 * @description:
 * @author: zhi
 * @date: 2021/7/26
 * @version: 1.0
 */
public class PersonService {

//	public void say() {
//		System.out.println("hello world.");
//	}

	public String say(String name) {
		System.out.println("hello world." + name);
		return name;
	}
}
