package com.couyis.base.rule.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.rule.IRuleService;
import com.couyis.base.rule.bean.RuleBean;
import com.couyis.base.rule.pojo.Rule;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/rule")
public class RuleController extends BaseController{
	@Resource
	private IRuleService ruleService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody RuleBean pageBean) {
		return ruleService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Rule rule, HttpServletRequest request) {
		rule.setCreateUser(getAccount(request));
		rule.setCreateTime(getNow());
		ruleService.save(rule);
	}

	@RequestMapping(value = "/edit/{id}")
	public Rule edit(@PathVariable("id") String id) {
		return ruleService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Rule rule, HttpServletRequest request) {
		rule.setUpdateUser(getAccount(request));
		rule.setUpdateTime(getNow());
		ruleService.update(rule);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		ruleService.delete(id);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			ruleService.delete(id);
		}
	}

	@RequestMapping(value = "/generate")
	public String generate(@RequestBody(required = false) String code) {
		return ruleService.generate(code);
	}

}
