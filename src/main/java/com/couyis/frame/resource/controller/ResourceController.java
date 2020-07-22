package com.couyis.frame.resource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;
import com.couyis.frame.resource.IResourceService;
import com.couyis.frame.resource.bean.ResourceBean;
import com.couyis.frame.resource.pojo.Resource;

@RestController
@RequestMapping("/frame/resource")
public class ResourceController extends BaseController {
	@javax.annotation.Resource
	private IResourceService resourceService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody ResourceBean pageBean) {
		return resourceService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Resource resource, HttpServletRequest request) {
		resource.setCreateTime(getNow());
		resource.setCreateUser(getAccount(request));
		resourceService.save(resource);
	}

	@RequestMapping(value = "/edit/{id}")
	public Resource edit(@PathVariable("id") String id) {
		return resourceService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Resource resource, HttpServletRequest request) {
		resource.setUpdateTime(getNow());
		resource.setUpdateUser(getAccount(request));
		resourceService.update(resource);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		resourceService.delete(id);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			resourceService.delete(id);
		}
	}

	@RequestMapping(value = "/findAll")
	public List<Resource> findAll() {
		return resourceService.findAll();
	}
}
