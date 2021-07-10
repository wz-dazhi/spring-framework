package com.springframework.test.tag;

/**
 * @projectName: spring
 * @package: com.springframework.test.tag
 * @className: DazhiTag
 * @description:
 * @author: zhi
 * @date: 2021/7/6
 * @version: 1.0
 */
public class DazhiTag {
	private String name;
	private int age;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DazhiTag{" +
				"name='" + name + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				'}';
	}
}
