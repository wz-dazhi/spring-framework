package com.webmvc.test.handler.adpater;

import javax.servlet.http.HttpServletRequest;

/**
 * @projectName: spring
 * @package: com.webmvc.test.handler.adpater
 * @className: Control
 * @description:
 * @author: zhi
 * @date: 2021/9/27
 * @version: 1.0
 */
@FunctionalInterface
public interface Control<T> {

	T process(HttpServletRequest req) throws Exception;

}
