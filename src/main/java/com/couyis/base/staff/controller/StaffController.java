package com.couyis.base.staff.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.staff.IStaffService;
import com.couyis.base.staff.bean.StaffBean;
import com.couyis.base.staff.pojo.Staff;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/staff")
public class StaffController extends BaseController {
	@Resource
	private IStaffService staffService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody StaffBean pageBean) {
		return staffService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Staff staff, HttpServletRequest request) {
		staff.setCreateUser(getAccount(request));
		staff.setCreateTime(getNow());
		staffService.save(staff);
	}

	@RequestMapping(value = "/edit/{id}")
	public Staff edit(@PathVariable("id") String id) {
		return staffService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Staff staff, HttpServletRequest request) {
		staff.setUpdateUser(getAccount(request));
		staff.setUpdateTime(getNow());
		staffService.update(staff);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		staffService.delete(id);
	}

	@RequestMapping(value = "/findByCode")
	public Staff findByCode(@RequestBody(required = false) String code) {
		return staffService.findByCode(code);
	}

	@RequestMapping(value = "/findByOrgPosition")
	public List<String> findByOrgPosition(@RequestBody(required = false) String orgId,
			@RequestBody(required = false) String positionId) {
		return staffService.findByOrgPosition(orgId, positionId);
	}

	@RequestMapping(value = "/dimission")
	public void dimission(@RequestBody String[] ids, HttpServletRequest request) {
		for (String id : ids) {
			staffService.dimission(id, getAccount(request), getNow());
		}
	}

	@RequestMapping(value = "/findSearch")
	public List<Staff> findSearch(String name) {
		return staffService.findSearch(name);
	}
}
