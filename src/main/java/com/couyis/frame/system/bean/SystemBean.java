package com.couyis.frame.system.bean;

import com.couyis.common.web.bean.PageBean;

public class SystemBean extends PageBean {
	private String id;

	private String name;

	private String domain;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
