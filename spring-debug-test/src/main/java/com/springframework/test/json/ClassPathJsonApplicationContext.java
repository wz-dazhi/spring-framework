package com.springframework.test.json;

import com.springframework.test.properties.ClassPathPropertiesApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.io.IOException;

/**
 * @projectName: spring
 * @package: com.springframework.test.json
 * @className: ClassPathJsonApplicationContext
 * @description:
 * @author: zhi
 * @date: 2021/7/10
 * @version: 1.0
 */
public class ClassPathJsonApplicationContext extends ClassPathPropertiesApplicationContext {

	public ClassPathJsonApplicationContext(String... configLocation) throws BeansException {
		super(configLocation);
	}

	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
		// 这里使用json的方式加载BeanDefinition
		JsonBeanDefinitionReader beanDefinitionReader = new JsonBeanDefinitionReader(beanFactory);
		beanDefinitionReader.setEnvironment(this.getEnvironment());
		beanDefinitionReader.setResourceLoader(this);
		loadBeanDefinitions(beanDefinitionReader);
	}
}
