package com.springframework.test.yaml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @projectName: spring
 * @package: com.springframework.test.yaml
 * @className: ClassPathYamlApplicationContext
 * @description:
 * @author: zhi
 * @date: 2021/7/11
 * @version: 1.0
 */
public class ClassPathYamlApplicationContext extends ClassPathXmlApplicationContext {

	public ClassPathYamlApplicationContext(String... configLocations) throws BeansException {
		super(configLocations);
	}

	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
		YamlBeanDefinitionReader beanDefinitionReader = new YamlBeanDefinitionReader(beanFactory);
		beanDefinitionReader.setEnvironment(this.getEnvironment());
		beanDefinitionReader.setResourceLoader(this);
		loadBeanDefinitions(beanDefinitionReader);
	}

	protected void loadBeanDefinitions(YamlBeanDefinitionReader reader) throws BeansException, IOException {
		String[] configLocations = getConfigLocations();
		if (configLocations != null) {
			reader.loadBeanDefinitions(configLocations);
		}
	}

}
