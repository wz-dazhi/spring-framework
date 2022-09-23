package com.springframework.test.xml.configuration;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.configuration
 * @className: ConfigurationTest
 * @description:
 * @author: zhi
 * @date: 2022/9/21
 * @version: 1.0
 */
public class ConfigurationTest {

	@Configuration
	public static class Config {

		@Bean
		public String s() {
			return "s";
		}
	}

	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/wangzhi/work/project/spring-framework/spring-debug-test/src/main/java/com/springframework/test/xml/configuration");
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		Config c = ac.getBean(Config.class);
		System.out.println(c);
	}
}
