package com.couyis.frame.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;
import com.couyis.frame.system.ISystemService;
import com.couyis.frame.system.bean.SystemBean;

@RestController
@RequestMapping("/frame/system")
public class SystemController extends BaseController {
	@Resource
	private ISystemService systemService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody SystemBean pageBean) {
		return systemService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody com.couyis.frame.system.pojo.System system, HttpServletRequest request) {
		system.setCreateUser(getAccount(request));
		system.setCreateTime(getNow());
		systemService.save(system);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody com.couyis.frame.system.pojo.System system, HttpServletRequest request) {
		system.setUpdateUser(getAccount(request));
		system.setUpdateTime(getNow());
		systemService.update(system);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public com.couyis.frame.system.pojo.System edit(@PathVariable("id") String id) {
		return systemService.findById(id);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		systemService.delete(id);
	}

	@RequestMapping(value = "/findAll")
	public List<com.couyis.frame.system.pojo.System> findAll() {
		return systemService.findAll();
	}

	@RequestMapping(value = "/getSecret")
	public String getSecret() {
		return UUIDUtil.get();
	}
}
