package com.springframework.test.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.io.IOException;

/**
 * @projectName: spring
 * @package: com.springframework.test.properties
 * @className: ClassPathPropertiesApplicationContext
 * @description:
 * @author: zhi
 * @date: 2021/7/7
 * @version: 1.0
 */
public class ClassPathPropertiesApplicationContext extends AbstractRefreshableConfigApplicationContext {

	public ClassPathPropertiesApplicationContext(String... configLocation) throws BeansException {
		this(configLocation, true, null);
	}

	public ClassPathPropertiesApplicationContext(String[] configLocations, boolean refresh, @Nullable ApplicationContext parent)
			throws BeansException {
		super(parent);
		setConfigLocations(configLocations);
		if (refresh) {
			refresh();
		}
	}

	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
		// 这里使用properties的方式加载BeanDefinition
		PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
		beanDefinitionReader.setEnvironment(this.getEnvironment());
		beanDefinitionReader.setResourceLoader(this);
		loadBeanDefinitions(beanDefinitionReader);
	}

	protected void loadBeanDefinitions(BeanDefinitionReader reader) throws BeansException, IOException {
		String[] configLocations = getConfigLocations();
		if (configLocations != null) {
			reader.loadBeanDefinitions(configLocations);
		}
	}

}
