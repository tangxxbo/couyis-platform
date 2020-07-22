package com.couyis.frame.resource.bean;

import java.util.List;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class ResourceBean extends PageBean {
	private String name;// 资源名称

	private String value;// 资源

	private List<String> attr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getAttr() {
		return attr;
	}

	public void setAttr(List<String> attr) {
		this.attr = attr;
	}

	@Override
	public String fieldConvert(String field) {
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "name":
				return "NAME";
			case "value":
				return "VALUE";
			case "attr":
				return "ATTR";
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