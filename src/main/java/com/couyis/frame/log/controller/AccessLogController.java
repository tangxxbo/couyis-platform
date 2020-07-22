package com.couyis.frame.log.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;
import com.couyis.frame.log.IAccessLogService;
import com.couyis.frame.log.bean.AccessLogBean;
import com.couyis.frame.log.pojo.AccessLog;

@RestController
@RequestMapping("/frame/accessLog")
public class AccessLogController{
	@Resource
	private IAccessLogService accessLogService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody AccessLogBean pageBean) {
		return accessLogService.findPage(pageBean);
	}

	@RequestMapping(value = "/add")
	public void add(@RequestBody AccessLog accessLog) {
		accessLogService.save(accessLog);
	}

	@RequestMapping(value = "/findById/{id}")
	public AccessLog findById(@PathVariable("id") String id) {
		return accessLogService.findById(id);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		accessLogService.delete(id);
	}
}
