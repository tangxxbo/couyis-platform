package com.couyis.frame.index.bean;

import java.util.List;

public class LoginResult {
	private Boolean login;

	private String message;

	private String accessToken;

	private String account;

	private List<Object> authoritys;

	public LoginResult(Boolean login, String message, String accessToken, String account, List<Object> authoritys) {
		super();
		this.login = login;
		this.message = message;
		this.accessToken = accessToken;
		this.account = account;
		this.authoritys = authoritys;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<Object> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Object> authoritys) {
		this.authoritys = authoritys;
	}

}
