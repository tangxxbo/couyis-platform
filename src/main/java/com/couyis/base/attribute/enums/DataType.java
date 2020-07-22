package com.couyis.base.attribute.enums;

import java.util.HashMap;
import java.util.Map;

import com.couyis.common.web.enums.BaseEnum;

public enum DataType implements BaseEnum<DataType, String> {

	CHAR("CHAR", "字符"), NUMBER("NUMBER", "数字"), DATE("DATE", "日期"), DCIT("DCIT", "数据字典");

	private String value;
	private String displayName;

	static Map<String, DataType> enumMap = new HashMap<String, DataType>();
	static {
		for (DataType type : DataType.values()) {
			enumMap.put(type.getValue(), type);
		}
	}

	private DataType(String value, String displayName) {
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

	public static DataType getEnum(String value) {
		return enumMap.get(value);
	}

	public static DataType get(String str) {
		for (DataType e : values()) {
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
