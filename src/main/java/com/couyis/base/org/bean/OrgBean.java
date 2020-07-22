package com.couyis.base.org.bean;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class OrgBean extends PageBean {
	private String code;

	private String name;// 名称

	private String parentName;// 上级名称

	private String parentId;

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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "code":
				return "A.CODE";
			case "name":
				return "A.NAME";
			case "parentName":
				return "B.NAME";
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
