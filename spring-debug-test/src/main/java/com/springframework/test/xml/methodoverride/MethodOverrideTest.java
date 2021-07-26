package com.springframework.test.xml.methodoverride;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.methodoverride
 * @className: MethodOverrideTest
 * @description:
 * @author: zhi
 * @date: 2021/7/26
 * @version: 1.0
 */
public class MethodOverrideTest {
	public static void main(String[] args) {
		// lookup-method man.getWoman() 每次获取的都是新的对象
//		ApplicationContext c = new ClassPathXmlApplicationContext("xml/lookup-method.xml");
//		final Man man = c.getBean(Man.class);
//		final Man man2 = c.getBean(Man.class);
//		System.out.println(man == man2);
//		System.out.println(man.getWoman());
//		System.out.println(man.getWoman());


		// replace-method 运行时替换需要执行的方法; 相同名字的方法, 有参和无参只能存在一个
		ApplicationContext c = new ClassPathXmlApplicationContext("xml/replacer-method.xml");
		final PersonService personService = c.getBean(PersonService.class);
		// 无参
		// personService.say();
		// 有参带返回值
		System.out.println(personService.say("张三"));
	}
}
