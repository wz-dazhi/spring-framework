package com.springframework.test.yaml;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Properties;

/**
 * @projectName: spring
 * @package: com.springframework.test.yaml
 * @className: YamlBeanDefinitionReader
 * @description:
 * @author: zhi
 * @date: 2021/7/11
 * @version: 1.0
 */
public class YamlBeanDefinitionReader extends PropertiesBeanDefinitionReader {
	public static final String CLASS_KEY = "class";
	public static final String PARENT_KEY = "parent";
	public static final String ABSTRACT_KEY = "abstract";
	public static final String SCOPE_KEY = "scope";
	public static final String SINGLETON_KEY = "singleton";
	public static final String LAZY_INIT_KEY = "lazy-init";
	public static final String REF_SUFFIX = "ref";

	private final YamlPropertiesFactoryBean processor = new YamlPropertiesFactoryBean();

	public YamlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public int loadBeanDefinitions(EncodedResource encodedResource, String prefix) throws BeanDefinitionStoreException {
		processor.setResources(encodedResource.getResource());
		final Properties properties = processor.getObject();
		return registerBeanDefinitions(properties, prefix, encodedResource.getResource().getDescription());
	}

	@Override
	protected void registerBeanDefinition(String beanName, Map<?, ?> map, String prefix, String resourceDescription) throws BeansException {
		String className = null;
		String parent = null;
		String scope = BeanDefinition.SCOPE_SINGLETON;
		boolean isAbstract = false;
		boolean lazyInit = false;

		ConstructorArgumentValues cas = new ConstructorArgumentValues();
		MutablePropertyValues pvs = new MutablePropertyValues();
		String prefixWithSep = prefix + SEPARATOR;
		int beginIndex = prefixWithSep.length();

		for (Map.Entry<?, ?> entry : map.entrySet()) {
			String key = StringUtils.trimWhitespace((String) entry.getKey());
			if (key.startsWith(prefixWithSep)) {
				String property = key.substring(beginIndex);
				if (CLASS_KEY.equals(property)) {
					className = StringUtils.trimWhitespace((String) entry.getValue());
				} else if (PARENT_KEY.equals(property)) {
					parent = StringUtils.trimWhitespace((String) entry.getValue());
				} else if (ABSTRACT_KEY.equals(property)) {
					String val = StringUtils.trimWhitespace((String) entry.getValue());
					isAbstract = TRUE_VALUE.equals(val);
				} else if (SCOPE_KEY.equals(property)) {
					scope = StringUtils.trimWhitespace((String) entry.getValue());
				} else if (SINGLETON_KEY.equals(property)) {
					String val = StringUtils.trimWhitespace((String) entry.getValue());
					scope = (!StringUtils.hasLength(val) || TRUE_VALUE.equals(val) ?
							BeanDefinition.SCOPE_SINGLETON : BeanDefinition.SCOPE_PROTOTYPE);
				} else if (LAZY_INIT_KEY.equals(property)) {
					String val = StringUtils.trimWhitespace((String) entry.getValue());
					lazyInit = TRUE_VALUE.equals(val);
				} else if (property.startsWith(CONSTRUCTOR_ARG_PREFIX)) {
					if (property.endsWith(REF_SUFFIX)) {
						int index = Integer.parseInt(property.substring(1, property.length() - REF_SUFFIX.length()));
						cas.addIndexedArgumentValue(index, new RuntimeBeanReference(entry.getValue().toString()));
					} else {
						int index = Integer.parseInt(property.substring(1));
						cas.addIndexedArgumentValue(index, readValue(entry));
					}
				} else if (property.endsWith(REF_SUFFIX)) {
					property = property.substring(0, property.length() - REF_SUFFIX.length());
					String ref = StringUtils.trimWhitespace((String) entry.getValue());

					Object val = new RuntimeBeanReference(ref);
					pvs.add(property, val);
				} else {
					pvs.add(property, readValue(entry));
				}
			}
		}

		if (parent == null && className == null && !beanName.equals(getDefaultParentBean())) {
			parent = getDefaultParentBean();
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

	private Object readValue(Map.Entry<?, ?> entry) {
		Object val = entry.getValue();
		if (val instanceof String) {
			String strVal = (String) val;
			if (strVal.startsWith(REF_PREFIX)) {
				String targetName = strVal.substring(1);
				if (targetName.startsWith(REF_PREFIX)) {
					val = targetName;
				} else {
					val = new RuntimeBeanReference(targetName);
				}
			}
		}
		return val;
	}
}
