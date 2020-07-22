package com.couyis.frame.authority.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.couyis.frame.resource.pojo.Resource;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Authority {
	private String id;// 主键ID

	private String code;// 权限编号

	private String name;// 权限名称

	private String remark; // 备注

	private Integer sort; // 顺序号
	
//	private System system;
//	
//	private String systemName;
//	
//	private String systemId;

	private AuthorityGroup authorityGroup;

	private String authorityGroupId;// 上级权限组

	private String authorityGroupName;// 上级权限组名称

	private List<Resource> resources = new ArrayList<Resource>();

	
	private String createUser;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
	private String updateUser;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getAuthorityGroupId() {
		return authorityGroupId;
	}

	public void setAuthorityGroupId(String authorityGroupId) {
		this.authorityGroupId = authorityGroupId;
	}

	public String getAuthorityGroupName() {
		return authorityGroupName;
	}

	public void setAuthorityGroupName(String authorityGroupName) {
		this.authorityGroupName = authorityGroupName;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}


	public AuthorityGroup getAuthorityGroup() {
		return authorityGroup;
	}

	public void setAuthorityGroup(AuthorityGroup authorityGroup) {
		this.authorityGroup = authorityGroup;
	}

//	public System getSystem() {
//		return system;
//	}
//
//	public void setSystem(System system) {
//		this.system = system;
//	}
//
//	public String getSystemName() {
//		return systemName;
//	}
//
//	public void setSystemName(String systemName) {
//		this.systemName = systemName;
//	}
//
//	public String getSystemId() {
//		return systemId;
//	}
//
//	public void setSystemId(String systemId) {
//		this.systemId = systemId;
//	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
