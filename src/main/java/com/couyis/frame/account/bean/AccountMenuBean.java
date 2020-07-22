package com.couyis.frame.account.bean;

import java.io.Serializable;
import java.util.List;

public class AccountMenuBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4733699098392851241L;

	private String menuId;

	private String menuName;

	private String value;

	private String parentId;
	
	private List<AccountMenuBean> AccountMenuBeans;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<AccountMenuBean> getAccountMenuBeans() {
		return AccountMenuBeans;
	}

	public void setAccountMenuBeans(List<AccountMenuBean> accountMenuBeans) {
		AccountMenuBeans = accountMenuBeans;
	}

}
