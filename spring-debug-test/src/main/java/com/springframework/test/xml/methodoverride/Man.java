package com.springframework.test.xml.methodoverride;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.methodoverride
 * @className: Man
 * @description:
 * @author: zhi
 * @date: 2021/7/26
 * @version: 1.0
 */
public class Man extends Person {
	private Woman woman;

	public void setWoman(Woman woman) {
		this.woman = woman;
	}

	public Woman getWoman() {
		return woman;
	}
}
