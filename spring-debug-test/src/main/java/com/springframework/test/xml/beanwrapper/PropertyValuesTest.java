package com.springframework.test.xml.beanwrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.beanwrapper
 * @className: PropertyValuesTest
 * @description:
 * @author: zhi
 * @date: 2021/9/24
 * @version: 1.0
 */
public class PropertyValuesTest {

	private static class User {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		User u = new User();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(u);
		bw.setPropertyValue("name", "李四");
		System.out.println(u.getName());
	}
}
