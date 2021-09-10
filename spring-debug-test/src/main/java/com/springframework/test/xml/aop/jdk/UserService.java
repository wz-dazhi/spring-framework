package com.springframework.test.xml.aop.jdk;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop
 * @className: UserService
 * @description:
 * @author: zhi
 * @date: 2021/7/27
 * @version: 1.0
 */
public class UserService implements IUserService {

	@Override
	public void show(String name) {
		System.out.println("-----UserService show()--------------" + name);
	}

	public void show2(String name) {
		System.out.println("-----UserService show2()--------------" + name);
	}
}
