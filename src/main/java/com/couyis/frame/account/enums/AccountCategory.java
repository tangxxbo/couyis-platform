package com.couyis.frame.account.enums;

import java.util.HashMap;
import java.util.Map;

import com.couyis.common.web.enums.BaseEnum;

public enum AccountCategory implements BaseEnum<AccountCategory, String> {
	COMMON("COMMON", "普通用户"), SYSTEM("SYSTEM", "系统用户");
	private String value;
	private String displayName;

	static Map<String, AccountCategory> enumMap = new HashMap<String, AccountCategory>();
	static {
		for (AccountCategory type : AccountCategory.values()) {
			enumMap.put(type.getValue(), type);
		}
	}

	private AccountCategory(String value, String displayName) {
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

	public static AccountCategory getEnum(String value) {
		return enumMap.get(value);
	}

	public static AccountCategory get(String str) {
		for (AccountCategory e : values()) {
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
