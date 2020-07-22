package com.couyis.base.staff.bean;

import java.util.List;

import org.springframework.util.StringUtils;

import com.couyis.base.staff.enums.StaffStatus;
import com.couyis.common.web.bean.PageBean;

public class StaffBean extends PageBean {
	private String code;
	private String name;
	private List<StaffStatus> status;
	private String acc;
	private String orgName;

	private String positionName;

	private String orgId;

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

	public List<StaffStatus> getStatus() {
		return status;
	}

	public void setStatus(List<StaffStatus> status) {
		this.status = status;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "code":
				return "A.CODE";
			case "name":
				return "A.NAME";
			case "status":
				return "A.STATUS";
			case "acc":
				return "B.ACCOUNT";
			case "orgName":
				return "D.NAME";
			case "positionName":
				return "C.NAME";
			case "createTime":
				return "A.CREATE_TIME";
			case "updateTime":
				return "A.UPDATE_TIME";
			default:
				return "";
			}
		}
		return "";
	}

}
