package com.springframework.test.xml.listener;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.listener
 * @className: UserEvent
 * @description:
 * @author: zhi
 * @date: 2021/9/9
 * @version: 1.0
 */
public class UserEvent {
	private String id;
	private String name;

	public UserEvent(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "UserEvent{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
