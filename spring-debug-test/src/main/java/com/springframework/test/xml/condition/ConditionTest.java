package com.springframework.test.xml.condition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.condition
 * @className: ConditionTest
 * @description:
 * @author: zhi
 * @date: 2022/9/21
 * @version: 1.0
 */
public class ConditionTest {

	private static boolean match(ConditionContext c, String os) {
		return os.equals(c.getEnvironment().getProperty("os.name"));
	}

	public static class WindowsConditional implements Condition {
		@Override
		public boolean matches(ConditionContext c, AnnotatedTypeMetadata metadata) {
			return match(c, "windows");
		}
	}

	public static class MacConditional implements Condition {
		@Override
		public boolean matches(ConditionContext c, AnnotatedTypeMetadata metadata) {
			return match(c, "Mac OS X");
		}
	}

	public static class LinuxConditional implements Condition {
		@Override
		public boolean matches(ConditionContext c, AnnotatedTypeMetadata metadata) {
			return match(c, "linux");
		}
	}

	@Configuration
	public static class Config {

		@Conditional(WindowsConditional.class)
		@Bean
		public String windows() {
			return "os.name -> windows";
		}

		@Conditional(MacConditional.class)
		@Bean
		public String mac() {
			return "os.name -> Mac OS X";
		}

		@Conditional(LinuxConditional.class)
		@Bean
		public String linux() {
			return "os.name -> linux";
		}

	}

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
//		String windows = ac.getBean("windows", String.class);
//		System.out.println(windows);
//		String mac = ac.getBean("mac", String.class);
//		System.out.println(mac);
//		String linux = ac.getBean("linux", String.class);
//		System.out.println(linux);
		String[] names = ac.getBeanNamesForType(String.class);
		System.out.println(Arrays.toString(names));
	}

}
