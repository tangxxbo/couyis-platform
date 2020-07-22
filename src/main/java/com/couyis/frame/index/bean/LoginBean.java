package com.couyis.frame.index.bean;

public class LoginBean {
	private String account;

	private String password;

	public LoginBean() {
		super();
	}

	public LoginBean(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
