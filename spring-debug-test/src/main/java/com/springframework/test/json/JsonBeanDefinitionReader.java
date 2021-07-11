package com.springframework.test.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @projectName: spring
 * @package: com.springframework.test.json
 * @className: JsonBeanDefinitionReader
 * @description:
 * @author: zhi
 * @date: 2021/7/10
 * @version: 1.0
 */
public class JsonBeanDefinitionReader extends PropertiesBeanDefinitionReader {
	public static final String CLASS_KEY = "class";
	public static final String PARENT_KEY = "parent";
	public static final String ABSTRACT_KEY = "abstract";
	public static final String LAZY_INIT_KEY = "lazy-init";

	public JsonBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public int loadBeanDefinitions(EncodedResource encodedResource, @Nullable String prefix) throws BeanDefinitionStoreException {
		try (InputStream is = encodedResource.getResource().getInputStream()) {
			ObjectMapper mapper = new ObjectMapper();
			final List<?> list = mapper.readValue(is, List.class);
			return registerBeanDefinitions(list, "List " + list);
		} catch (IOException e) {
			throw new BeanDefinitionStoreException("Could not parse json from " + encodedResource.getResource(), e);
		}
	}

	public int registerBeanDefinitions(List<?> list, String resourceDescription) throws BeansException {
		int beanCount = 0;
		for (Object m : list) {
			if (!(m instanceof Map)) {
				throw new IllegalArgumentException("Illegal key [" + m + "]: only map allowed");
			}
			Map<?, ?> map = (Map<?, ?>) m;
			final String beanName = String.valueOf(map.get(CLASS_KEY));
			if (!getRegistry().containsBeanDefinition(beanName)) {
				registerBeanDefinition(beanName, map, resourceDescription);
				++beanCount;
			}
		}
		return beanCount;
	}

	protected void registerBeanDefinition(String beanName, Map<?, ?> map, String resourceDescription) throws BeansException {
		String className = null;
		String parent = null;
		String scope = BeanDefinition.SCOPE_SINGLETON;
		boolean isAbstract = false;
		boolean lazyInit = false;

		ConstructorArgumentValues cas = new ConstructorArgumentValues();
		MutablePropertyValues pvs = new MutablePropertyValues();
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			String key = StringUtils.trimWhitespace((String) entry.getKey());
			switch (key) {
				case CLASS_KEY:
					className = StringUtils.trimWhitespace((String) entry.getValue());
					break;
				case PARENT_KEY:
					parent = StringUtils.trimWhitespace((String) entry.getValue());
					break;
				case ABSTRACT_KEY: {
					String val = StringUtils.trimWhitespace(String.valueOf(entry.getValue()));
					isAbstract = TRUE_VALUE.equals(val);
					break;
				}
				case LAZY_INIT_KEY: {
					String val = StringUtils.trimWhitespace(String.valueOf(entry.getValue()));
					lazyInit = TRUE_VALUE.equals(val);
					break;
				}
				default:
					// It's a normal bean property.
					pvs.add(key, entry.getValue());
					break;
			}
		}

		try {
			AbstractBeanDefinition bd = BeanDefinitionReaderUtils.createBeanDefinition(parent, className, getBeanClassLoader());
			bd.setScope(scope);
			bd.setAbstract(isAbstract);
			bd.setLazyInit(lazyInit);
			bd.setConstructorArgumentValues(cas);
			bd.setPropertyValues(pvs);
			getRegistry().registerBeanDefinition(beanName, bd);
		} catch (ClassNotFoundException ex) {
			throw new CannotLoadBeanClassException(resourceDescription, beanName, className, ex);
		} catch (LinkageError err) {
			throw new CannotLoadBeanClassException(resourceDescription, beanName, className, err);
		}
	}
}
