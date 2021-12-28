package com.springframework.test.xml.tx;

import java.util.List;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.tx
 * @className: UserService
 * @description:
 * @author: zhi
 * @date: 2021/12/28
 * @version: 1.0
 */
public interface UserService {

	User getById(Long id);

	int add(User u);

	List<User> getAll();
}
