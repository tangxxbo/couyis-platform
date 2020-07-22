package com.couyis.base.staff.enums;

import java.util.HashMap;
import java.util.Map;

import com.couyis.common.web.enums.BaseEnum;

public enum StaffStatus implements BaseEnum<StaffStatus, String> {
	NORMAL("NORMAL", "正常"), QUIT("QUIT", "离职");
	private String value;
	private String displayName;

	static Map<String, StaffStatus> enumMap = new HashMap<String, StaffStatus>();
	static {
		for (StaffStatus type : StaffStatus.values()) {
			enumMap.put(type.getValue(), type);
		}
	}

	private StaffStatus(String value, String displayName) {
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

	public static StaffStatus getEnum(String value) {
		return enumMap.get(value);
	}

	public static StaffStatus get(String str) {
		for (StaffStatus e : values()) {
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
