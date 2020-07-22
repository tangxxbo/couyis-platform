package com.couyis.base.staff.pojo;

import java.util.Date;

import com.couyis.base.org.pojo.Org;
import com.couyis.base.position.pojo.Position;
import com.couyis.base.staff.enums.StaffStatus;
import com.couyis.frame.account.pojo.Account;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Staff {
	private String id;

	private String code;

	private String name;

	private StaffStatus status;

	private String accountId;

	private String acc;

	private String email;

	private String orgId;

	private String orgName;

	private Org org;

	private String positionId;

	private String positionName;

	private Position position;

	private Account account;

//	private List<Role> roles = new ArrayList<Role>();
//	
//	private List<Authority> authoritys = new ArrayList<Authority>();

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

	public StaffStatus getStatus() {
		return status;
	}

	public void setStatus(StaffStatus status) {
		this.status = status;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

//	public String getAccount() {
//		return account;
//	}
//
//	public void setAccount(String account) {
//		this.account = account;
//	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

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

//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
//
//	public List<Authority> getAuthoritys() {
//		return authoritys;
//	}
//
//	public void setAuthoritys(List<Authority> authoritys) {
//		this.authoritys = authoritys;
//	}

}
