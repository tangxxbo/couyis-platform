package com.couyis.base.dict.bean;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class DictBean extends PageBean {
	private String code;

	private String name;// 数据字典名称

	private String parentName;// 上级数据字典名称

	private String parentId;

	private String parentCode;

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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
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
			case "sort":
				return "A.SORT";
			case "createTime":
				return "A.CREATE_TIME";
			case "updateTime":
				return "A.UPDATE_TIME";
			default:
				return "";
			}
		}
		return "";
	}

}
