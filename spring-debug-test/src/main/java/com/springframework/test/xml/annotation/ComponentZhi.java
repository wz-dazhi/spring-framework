package com.springframework.test.xml.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.annotation
 * @className: ComponentZhi
 * @description:
 * @author: zhi
 * @date: 2021/7/21
 * @version: 1.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentZhi {
}
