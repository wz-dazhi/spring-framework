package com.springframework.test.xml.beanfactorypostprocessor;

import com.springframework.test.xml.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.beanfactorypostprocessor
 * @className: MyBeanDefinitionRegistryPostProcessor
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor --> 执行postProcessBeanFactory");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor --> 执行postProcessBeanDefinitionRegistry");
		final BeanDefinition bd = registry.getBeanDefinition("user");
		bd.setScope("singleton");

		final GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(User.class);
		final MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("name", "手动注册"));
		beanDefinition.setPropertyValues(propertyValues);
		registry.registerBeanDefinition("u2", beanDefinition);
	}
}
