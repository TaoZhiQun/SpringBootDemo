package com.example.entity;

import java.io.Serializable;

public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private String loginIp;

	private Integer operateType;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
}
