package com.couyis.frame.account.pojo;

import java.util.ArrayList;
import java.util.List;

import com.couyis.frame.account.enums.AccountCategory;
import com.couyis.frame.authority.pojo.Authority;
import com.couyis.frame.role.pojo.Role;

/**
 * 对应菜单表数据
 * 
 * @author 邓放平
 *
 */
public class Account {
	private String id;// 主键ID
	private String account;// 菜单名称
	private AccountCategory category;// 备注
	private String password;// 上级菜单ID
	
	private List<Role> roles = new ArrayList<Role>();
	
	private List<Authority> authoritys = new ArrayList<Authority>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public AccountCategory getCategory() {
		return category;
	}

	public void setCategory(AccountCategory category) {
		this.category = category;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
	}

}