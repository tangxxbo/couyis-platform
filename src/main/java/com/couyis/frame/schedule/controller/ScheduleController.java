package com.couyis.frame.schedule.controller;

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
import com.couyis.frame.schedule.IScheduleService;
import com.couyis.frame.schedule.bean.ScheduleBean;
import com.couyis.frame.schedule.enums.ScheduleStatus;
import com.couyis.frame.schedule.pojo.Schedule;

@RestController
@RequestMapping("/frame/schedule")
public class ScheduleController extends BaseController{
	@Resource
	private IScheduleService scheduleService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody ScheduleBean pageBean) {
		return scheduleService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Schedule schedule, HttpServletRequest request) {
		schedule.setCreateTime(getNow());
		schedule.setCreateUser(getAccount(request));
		scheduleService.save(schedule);
	}

	@RequestMapping(value = "/edit/{id}")
	public Schedule edit(@PathVariable("id") String id) {
		return scheduleService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Schedule schedule, HttpServletRequest request) {
		schedule.setCreateTime(getNow());
		schedule.setCreateUser(getAccount(request));
		scheduleService.update(schedule);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		scheduleService.delete(id);
	}

	@RequestMapping(value = "/findByStatus")
	public List<Schedule> findByStatus(@RequestBody(required = false) ScheduleStatus status) {
		return scheduleService.findByStatus(status);
	}

}
