package com.couyis.frame.resource.enums;

import java.util.HashMap;
import java.util.Map;

import com.couyis.common.web.enums.BaseEnum;

public enum ResourceAttr implements BaseEnum<ResourceAttr, String> {
	PROTECTED("PROTECTED", "非授权资源"), PRIVATE("PRIVATE", "需授权资源");
	private String value;
	private String displayName;

	static Map<String, ResourceAttr> enumMap = new HashMap<String, ResourceAttr>();
	static {
		for (ResourceAttr type : ResourceAttr.values()) {
			enumMap.put(type.getValue(), type);
		}
	}

	private ResourceAttr(String value, String displayName) {
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

	public static ResourceAttr getEnum(String value) {
		return enumMap.get(value);
	}

	public static ResourceAttr get(String str) {
		for (ResourceAttr e : values()) {
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
