package com.springframework.test.groovy;

import com.springframework.test.properties.ClassPathPropertiesApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.io.IOException;

/**
 * @projectName: spring
 * @package: com.springframework.test.groovy
 * @className: ClassPathGroovyApplicationContext
 * @description:
 * @author: zhi
 * @date: 2021/7/7
 * @version: 1.0
 */
public class ClassPathGroovyApplicationContext extends ClassPathPropertiesApplicationContext {

	public ClassPathGroovyApplicationContext(String... configLocation) throws BeansException {
		super(configLocation);
	}

	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
		// 这里使用groovy的方式加载BeanDefinition
		GroovyBeanDefinitionReader beanDefinitionReader = new GroovyBeanDefinitionReader(beanFactory);
		loadBeanDefinitions(beanDefinitionReader);
	}

}
