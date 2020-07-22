package com.couyis.base.attribute.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.attribute.IAttributeService;
import com.couyis.base.attribute.bean.AttributeBean;
import com.couyis.base.attribute.pojo.Attribute;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/attribute")
public class AttributeController extends BaseController {
	@Resource
	private IAttributeService attributeService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody AttributeBean pageBean) {
		return attributeService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Attribute attribute, HttpServletRequest request) {
		attribute.setCreateUser(getAccount(request));
		attribute.setCreateTime(getNow());
		attributeService.save(attribute);
	}

	@RequestMapping(value = "/edit/{id}")
	public Attribute edit(@PathVariable("id") String id) {
		return attributeService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Attribute attribute, HttpServletRequest request) {
		attribute.setUpdateUser(getAccount(request));
		attribute.setUpdateTime(getNow());
		attributeService.update(attribute);
	}

	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids, HttpServletRequest request) {
		for (String id : ids) {
			attributeService.delete(id, getAccount(request), getNow());
		}
	}
	
	@RequestMapping(value = "/findAll")
	public List<Attribute> findAll() {
		return attributeService.findAll();
	}
}
