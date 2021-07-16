package com.springframework.test.xml.factorymethod;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.factorymethod
 * @className: DynamicFactoryMethod
 * @description:
 * @author: zhi
 * @date: 2021/7/16
 * @version: 1.0
 */
public class DynamicFactoryMethod {
	public Person getPerson() {
		return new Person("lisi");
	}
}
