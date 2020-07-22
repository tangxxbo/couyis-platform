package com.couyis.frame.schedule.enums;

import java.util.HashMap;
import java.util.Map;

import com.couyis.common.web.enums.BaseEnum;

public enum ScheduleStatus implements BaseEnum<ScheduleStatus, String> {
	CREATE("CREATE", "创建"), START("START", "启动"), EXCUTE("EXCUTE", "执行中"), STOP("STOP", "停止"), STANDBY("STANDBY",
			"待命"), ERROR("ERROR", "错误");
	private String value;
	private String displayName;

	static Map<String, ScheduleStatus> enumMap = new HashMap<String, ScheduleStatus>();
	static {
		for (ScheduleStatus type : ScheduleStatus.values()) {
			enumMap.put(type.getValue(), type);
		}
	}

	private ScheduleStatus(String value, String displayName) {
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

	public static ScheduleStatus getEnum(String value) {
		return enumMap.get(value);
	}

	public static ScheduleStatus get(String str) {
		for (ScheduleStatus e : values()) {
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
