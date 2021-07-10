package com.springframework.test.xml.context;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.context
 * @className: MyClassPathXmlApplicationContext
 * @description:
 * @author: zhi
 * @date: 2021/7/6
 * @version: 1.0
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathXmlApplicationContext(String... configLocations) throws BeansException {
		super(configLocations);
	}

	@Override
	public ConfigurableEnvironment getEnvironment() {
		final ConfigurableEnvironment e = super.getEnvironment();
		final MutablePropertySources sources = e.getPropertySources();
		Properties p = new Properties();
		p.put("user.namezh", "wangzhizh");
		sources.addLast(new PropertiesPropertySource("customProperties", p));
		return e;
	}
}
