package com.couyis.frame.resource.pojo;

import java.util.Date;

import com.couyis.frame.resource.enums.ResourceAttr;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 对应资源表数据
 * 
 * @author 邓放平
 *
 */
public class Resource {
	private String id;// 主键ID
	
	private String name;// 菜单名称
	
	private String remark;// 备注
	
	private String value;// 资源值
	
//	private String menuId;// 菜单ID
//	
//	private String menuName;// 菜单名称
//	
//	private Menu menu;
	
	private ResourceAttr attr;
	
	private String createUser;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	private String updateUser;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

//	public Menu getMenu() {
//		return menu;
//	}
//
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

//	public String getMenuId() {
//		return menuId;
//	}
//
//	public void setMenuId(String menuId) {
//		this.menuId = menuId;
//	}
//
//	public String getMenuName() {
//		return menuName;
//	}
//
//	public void setMenuName(String menuName) {
//		this.menuName = menuName;
//	}

	public ResourceAttr getAttr() {
		return attr;
	}

	public void setAttr(ResourceAttr attr) {
		this.attr = attr;
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

}