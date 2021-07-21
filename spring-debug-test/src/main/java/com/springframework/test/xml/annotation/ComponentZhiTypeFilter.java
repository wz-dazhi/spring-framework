package com.springframework.test.xml.annotation;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.annotation
 * @className: ComponentZhiTypeFilter
 * @description:
 * @author: zhi
 * @date: 2021/7/21
 * @version: 1.0
 */
public class ComponentZhiTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		return metadataReader.getAnnotationMetadata().isAnnotated(ComponentZhi.class.getName());
	}

}
