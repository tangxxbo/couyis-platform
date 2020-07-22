package com.couyis.base.classification.bean;

import org.springframework.util.StringUtils;

import com.couyis.base.classification.enums.Category;
import com.couyis.common.web.bean.PageBean;

public class ClassificationBean extends PageBean {
	private String code;

	private String name;

	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "code":
				return "CODE";
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
