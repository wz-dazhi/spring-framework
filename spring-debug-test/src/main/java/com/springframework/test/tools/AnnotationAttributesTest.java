package com.springframework.test.tools;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @projectName: spring
 * @package: com.springframework.test.tools
 * @className: AnnotationAttributesTest
 * @description:
 * @author: zhi
 * @date: 2022/1/13
 * @version: 1.0
 */
@Test(value = "hello", color = Test.Color.GREEN, clazz = AnnotationAttributesTest.class)
public class AnnotationAttributesTest {

	public static void main(String[] args) {
		AnnotationAttributes attributes = AnnotationUtils.getAnnotationAttributes(AnnotationAttributesTest.class, AnnotationAttributesTest.class.getAnnotation(Test.class));
		System.out.println(attributes);
		System.out.println(attributes.getString("value"));
		System.out.println(attributes.getEnum("color"));
		System.out.println(attributes.getClass("clazz"));
	}
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Test {

	String value() default "";

	Color color() default Color.RED;

	Class<?> clazz() default Object.class;

	enum Color {
		RED, GREEN
	}
}