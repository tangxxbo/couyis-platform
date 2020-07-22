package com.couyis.frame.account.bean;

import com.couyis.common.web.bean.PageBean;

/**
 * 对应菜单表数据
 * 
 * @author 邓放平
 *
 */
public class AccountBean extends PageBean {
	private String id;// 主键ID
	private String account;// 帐号
	private String category;// 类型

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}