package com.springframework.test.xml.tx;

import java.time.LocalDateTime;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.tx
 * @className: User
 * @description:
 * @author: zhi
 * @date: 2021/12/28
 * @version: 1.0
 */
public class User {
	private Long id;
	private String userNo;
	private String username;
	private String password;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userNo='" + userNo + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
