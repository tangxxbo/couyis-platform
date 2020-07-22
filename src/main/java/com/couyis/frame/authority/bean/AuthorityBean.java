package com.couyis.frame.authority.bean;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class AuthorityBean extends PageBean{
	
	private String code;
	
	private String name;// 名称
	
	private String authgrpId;
	
	private String authorityGroupName;// 权限组名称

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

	public String getAuthgrpId() {
		return authgrpId;
	}

	public void setAuthgrpId(String authgrpId) {
		this.authgrpId = authgrpId;
	}

	public String getAuthorityGroupName() {
		return authorityGroupName;
	}

	public void setAuthorityGroupName(String authorityGroupName) {
		this.authorityGroupName = authorityGroupName;
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
			case "authorityGroupName":
				return "B.NAME";
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
