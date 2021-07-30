package com.springframework.test.xml.aop.declareparents;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop.declareparents
 * @className: Man
 * @description:
 * @author: zhi
 * @date: 2021/7/29
 * @version: 1.0
 */
//@Component
public class Man implements Person {
	@Override
	public void say() {
		System.out.println("Man --- say.");
	}
}
