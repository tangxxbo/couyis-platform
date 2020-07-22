package com.couyis.frame.schedule.pojo;

import java.util.Date;

import com.couyis.frame.schedule.enums.ScheduleStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Schedule {
	private String id;

	private String name;

	private String cron;

	private String clazz;

	private ScheduleStatus status;

	private String createUser;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	private String startUser;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;

	private String stopUser;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date stopTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public ScheduleStatus getStatus() {
		return status;
	}

	public void setStatus(ScheduleStatus status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getStartUser() {
		return startUser;
	}

	public void setStartUser(String startUser) {
		this.startUser = startUser;
	}

	public String getStopUser() {
		return stopUser;
	}

	public void setStopUser(String stopUser) {
		this.stopUser = stopUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

}
