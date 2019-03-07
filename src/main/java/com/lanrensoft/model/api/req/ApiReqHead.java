package com.lanrensoft.model.api.req;

import org.hibernate.validator.constraints.NotBlank;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户端请求参数头（通用参数模型）
 */
public class ApiReqHead {

	@NotBlank
	private String token;
	@NotBlank
	private String uid;
	@NotBlank
	private String time;
	@NotBlank
	private String client;
	/**
	 * 客户端版本
	 */
	private String version;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
