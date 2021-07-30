package com.springframework.test.xml.aop.declareparents;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop.declareparents
 * @className: Dog
 * @description:
 * @author: zhi
 * @date: 2021/7/29
 * @version: 1.0
 */
public class Dog implements Animal {
	@Override
	public void run() {
		System.out.println("Dog --- run.");
	}
}
