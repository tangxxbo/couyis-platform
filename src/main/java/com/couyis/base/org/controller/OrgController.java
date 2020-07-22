package com.couyis.base.org.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.org.IOrgService;
import com.couyis.base.org.bean.OrgBean;
import com.couyis.base.org.pojo.Org;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/org")
public class OrgController extends BaseController{
	@Resource
	private IOrgService orgService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody OrgBean pageBean) {
		return orgService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody Org org, HttpServletRequest request) {
		org.setCreateUser(getAccount(request));
		org.setCreateTime(getNow());
		orgService.save(org);
	}

	@RequestMapping(value = "/edit/{id}")
	public Org edit(@PathVariable("id") String id) {
		return orgService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Org org, HttpServletRequest request) {
		org.setUpdateUser(getAccount(request));
		org.setUpdateTime(getNow());
		orgService.update(org);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		orgService.delete(id);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			orgService.delete(id);
		}
	}
	
	@RequestMapping(value = "/findAll")
	public List<Org> findAll() {
		return orgService.findAll();
	}

	@RequestMapping(value = "/findTree")
	public List<Org> findTree() {
		return orgService.findTree();
	}

//	@RequestMapping(value = "/findTreeLookUp")
//	public String findTreeLookUp() {
//		return orgService.findTreeLookUp();
//	}

	@RequestMapping(value = "/findByParentId")
	public List<Org> findByParentId(@RequestBody(required = false) String parentId) {
		return orgService.findByParentId(parentId);
	}

	@RequestMapping(value = "/findChildById")
	public List<Org> findChildById(@RequestBody(required = false) String id) {
		return orgService.findChildById(id);
	}
}
