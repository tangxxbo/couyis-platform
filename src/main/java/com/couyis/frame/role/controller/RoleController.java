package com.couyis.frame.role.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;
import com.couyis.frame.role.IRoleService;
import com.couyis.frame.role.bean.RoleBean;
import com.couyis.frame.role.pojo.Role;

@RestController
@RequestMapping("/frame/role")
public class RoleController extends BaseController{
	@Resource
	private IRoleService roleService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody RoleBean pageBean) {
		return roleService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Role role, HttpServletRequest request) {
		role.setCreateTime(getNow());
		role.setCreateUser(getAccount(request));
		roleService.save(role);
	}

	@RequestMapping(value = "/edit/{id}")
	public Role edit(@PathVariable("id") String id) {
		return roleService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Role role, HttpServletRequest request) {
		role.setCreateTime(getNow());
		role.setCreateUser(getAccount(request));
		roleService.update(role);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			roleService.delete(id);
		}
	}	

	@RequestMapping(value = "/findAuthorityByRoleId")
	public List<String> findAuthorityByRoleId(@RequestBody(required = false) String roleId) {
		return roleService.findAuthorityByRoleId(roleId);
	}

	@RequestMapping(value = "/findByAccount")
	public List<Role> findByAccount(@RequestBody(required = false) String account) {
		return roleService.findByAccount(account);
	}

	@RequestMapping(value = "/findAll")
	public List<Role> findAll() {
		return roleService.findAll();
	}

}
