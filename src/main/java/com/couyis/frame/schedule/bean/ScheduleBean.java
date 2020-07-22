package com.couyis.frame.schedule.bean;

import com.couyis.common.web.bean.PageBean;

public class ScheduleBean extends PageBean {
	private String clazz;

	private String name;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
