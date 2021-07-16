package com.springframework.test.xml.factorymethod;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.factorymethod
 * @className: StaticFactoryMethod
 * @description:
 * @author: zhi
 * @date: 2021/7/16
 * @version: 1.0
 */
public class StaticFactoryMethod {
	public static Person getPerson() {
		return new Person("zhangsan");
	}
}
