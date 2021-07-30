package com.springframework.test.xml.aop.declareparents;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop.declareparents
 * @className: PersonAspect
 * @description:
 * @author: zhi
 * @date: 2021/7/29
 * @version: 1.0
 */
//@Aspect
//@Component
public class PersonAspect {
//	@DeclareParents(value = "com.springframework.test.xml.aop.declareparents.Man", defaultImpl = Dog.class)
	private Animal animal;
}
