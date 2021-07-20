package com.springframework.test.xml.customeditor;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.customeditor
 * @className: Address
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class Address {
	private String province;
	private String city;
	private String county;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Override
	public String toString() {
		return "Address{" +
				"province='" + province + '\'' +
				", city='" + city + '\'' +
				", county='" + county + '\'' +
				'}';
	}
}
