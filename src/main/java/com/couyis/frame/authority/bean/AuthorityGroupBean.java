package com.couyis.frame.authority.bean;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class AuthorityGroupBean extends PageBean{
	private String name;// 权限组名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "name":
				return "NAME";
			case "createTime":
				return "CREATE_TIME";
			case "updateTime":
				return "UPDATE_TIME";
			default:
				return "";
			}
		}
		return "";
	}
}
