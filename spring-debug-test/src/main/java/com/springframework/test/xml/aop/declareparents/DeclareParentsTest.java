package com.springframework.test.xml.aop.declareparents;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop.declareparents
 * @className: DeclareParentsTest
 * @description:
 * @author: zhi
 * @date: 2021/7/29
 * @version: 1.0
 */
public class DeclareParentsTest {
	public static void main(String[] args) throws Exception {
//		String dir = "/Users/wangzhi/work/project/spring-framework/spring-debug-test/src/main/java/com/springframework/test/xml/aop/declareparents";
//		saveFile(dir);
		ApplicationContext c = new ClassPathXmlApplicationContext("aop/declare-parents.xml");
		// 实现接口不能强制转换, 接口使用jdk代理, 会实现Person Animal 接口
		//Man man = (Man) c.getBean("man");
		Person man = (Person) c.getBean("man");
		man.say();
		((Animal) man).run();
//		System.out.println(man + " <--> " + man.getClass().getName());
//		for (Class<?> anInterface : man.getClass().getInterfaces()) {
//			System.out.println(anInterface);
//		}
	}

	public static void saveFile(String dir) throws Exception {
		System.getProperties().put(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);
		System.getProperties().put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
	}
}
