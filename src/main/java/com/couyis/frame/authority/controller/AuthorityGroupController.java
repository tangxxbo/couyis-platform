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
import com.couyis.frame.authority.IAuthorityGroupService;
import com.couyis.frame.authority.bean.AuthorityGroupBean;
import com.couyis.frame.authority.pojo.AuthorityGroup;

@RestController
@RequestMapping("/frame/authgrp")
public class AuthorityGroupController extends BaseController {
	@Resource
	private IAuthorityGroupService authorityGroupService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody AuthorityGroupBean pageBean) {
		return authorityGroupService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody AuthorityGroup authorityGroup, HttpServletRequest request) {
		authorityGroup.setCreateTime(getNow());
		authorityGroup.setCreateUser(getAccount(request));
		authorityGroupService.save(authorityGroup);
	}

	@RequestMapping(value = "/edit/{id}")
	public AuthorityGroup edit(@PathVariable("id") String id) {
		return authorityGroupService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody AuthorityGroup authorityGroup, HttpServletRequest request) {
		authorityGroup.setUpdateTime(getNow());
		authorityGroup.setUpdateUser(getAccount(request));
		authorityGroupService.update(authorityGroup);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		authorityGroupService.delete(id);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			authorityGroupService.delete(id);
		}
	}

	@RequestMapping(value = "/findAll")
	public List<AuthorityGroup> findAll() {
		return authorityGroupService.findAll();
	}
}
