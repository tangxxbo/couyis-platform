package com.couyis.base.unit.bean;

import com.couyis.common.web.bean.PageBean;

public class UnitBean extends PageBean {
	private String code;

	private String name;

	private String category;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
