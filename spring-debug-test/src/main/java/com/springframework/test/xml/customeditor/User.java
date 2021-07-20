package com.springframework.test.xml.customeditor;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.customeditor
 * @className: User
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class User {
	private String name;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", address=" + address +
				'}';
	}
}
