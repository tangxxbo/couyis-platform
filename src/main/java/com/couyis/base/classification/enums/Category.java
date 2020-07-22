package com.couyis.base.classification.enums;

import java.util.HashMap;
import java.util.Map;

import com.couyis.common.web.enums.BaseEnum;

public enum Category implements BaseEnum<Category, String> {

	MATERIAL("MATERIAL", "物料"), BATCH("BATCH", "批次"), CONFIG("CONFIG", "配置"), VAR("VAR", "变式"),ATTR("ATTR", "附加信息");

	private String value;
	private String displayName;

	static Map<String, Category> enumMap = new HashMap<String, Category>();
	static {
		for (Category type : Category.values()) {
			enumMap.put(type.getValue(), type);
		}
	}

	private Category(String value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public static Category getEnum(String value) {
		return enumMap.get(value);
	}

	public static Category get(String str) {
		for (Category e : values()) {
			if (e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return displayName;
	}

}
