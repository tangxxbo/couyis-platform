package com.couyis.base.rule.bean;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class RuleBean extends PageBean {
	private String code;
	
	private String dateFormat;
	
	private String prefix;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "code":
				return "CODE";
			case "dateFormat":
				return "DATE_FORMAT";
			case "prefix":
				return "PREFIX";
			case "counts":
				return "COUNTS";
			case "number":
				return "NUMBER_";
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
