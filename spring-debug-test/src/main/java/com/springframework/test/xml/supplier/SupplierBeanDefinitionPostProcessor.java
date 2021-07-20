package com.springframework.test.xml.supplier;

import com.springframework.test.xml.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.supplier
 * @className: SupplierBeanDefinitionPostProcessor
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class SupplierBeanDefinitionPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("SupplierBeanDefinitionPostProcessor --> 执行 postProcessBeanFactory");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("SupplierBeanDefinitionPostProcessor --> 执行 postProcessBeanDefinitionRegistry");
		final BeanDefinition beanDefinition = registry.getBeanDefinition("user");
		if (beanDefinition instanceof AbstractBeanDefinition) {
			// 使用supplier的方式进行实例化
			// ((AbstractBeanDefinition) beanDefinition).setInstanceSupplier(User::new);
			((AbstractBeanDefinition) beanDefinition).setInstanceSupplier(() -> new User("SupplierBeanDefinitionPostProcessor"));
		}
	}
}
