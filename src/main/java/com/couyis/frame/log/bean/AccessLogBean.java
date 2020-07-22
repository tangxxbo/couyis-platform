package com.couyis.frame.log.bean;

import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class AccessLogBean extends PageBean {

	private String url;

	private String createUser;

	private String ipAddress;

	private List<Date> createTime;

	private Date startTime;

	private Date endTime;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public List<Date> getCreateTime() {
		return createTime;
	}

	public void setCreateTime(List<Date> createTime) {
		if (createTime == null || createTime.size() < 1) {
			return;
		}

		this.setStartTime(createTime.get(0));
		this.setEndTime(createTime.get(1));
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String fieldConvert(String field) {
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "url":
				return "URL";
			case "ipAddress":
				return "IP_ADDRESS";
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
