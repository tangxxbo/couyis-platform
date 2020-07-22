package com.couyis.frame.authority.controller;

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
import com.couyis.frame.authority.IAuthorityService;
import com.couyis.frame.authority.bean.AuthorityBean;
import com.couyis.frame.authority.pojo.Authority;

@RestController
@RequestMapping("/frame/authority")
public class AuthorityController extends BaseController{
	@Resource
	private IAuthorityService authorityService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody AuthorityBean pageBean) {
		return authorityService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Authority authority, HttpServletRequest request) {
		authority.setCreateTime(getNow());
		authority.setCreateUser(getAccount(request));
		authorityService.save(authority);
	}

	@RequestMapping(value = "/edit/{id}")
	public Authority edit(@PathVariable("id") String id) {
		return authorityService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Authority authority, HttpServletRequest request) {
		authority.setUpdateTime(getNow());
		authority.setUpdateUser(getAccount(request));
		authorityService.update(authority);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		authorityService.delete(id);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			authorityService.delete(id);
		}
	}

	@RequestMapping(value = "/findAll")
	public List<Authority> findAll() {
		return authorityService.findAll();
	}

}
