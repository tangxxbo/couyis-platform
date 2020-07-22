package com.couyis.base.attribute.bean;

import org.springframework.util.StringUtils;

import com.couyis.base.attribute.enums.DataType;
import com.couyis.common.web.bean.PageBean;

public class AttributeBean extends PageBean {
	private String code;

	private String name;

	private DataType dataType;

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

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
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
			case "dataType":
				return "DATA_TYPE";
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
