package com.webmvc.test.handler.beanname;

import com.webmvc.test.handler.adpater.Control;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: spring
 * @package: com.webmvc.test.handler.beanname
 * @className: DControl
 * @description:
 * @author: zhi
 * @date: 2021/9/27
 * @version: 1.0
 */
@SuppressWarnings("serial")
public class DControl implements Control<Map<String, Object>> {

	@Override
	public Map<String, Object> process(HttpServletRequest req) throws Exception {
		return new HashMap<String, Object>() {{
			put("key", "Customer Control => " + req.getParameter("name"));
		}};
	}

}
