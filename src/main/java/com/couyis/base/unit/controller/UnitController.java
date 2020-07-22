package com.couyis.base.unit.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.unit.IUnitService;
import com.couyis.base.unit.bean.UnitBean;
import com.couyis.base.unit.pojo.Unit;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/unit")
public class UnitController extends BaseController {
	@Resource
	private IUnitService unitService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody UnitBean pageBean) {
		return unitService.findPage(pageBean);
	}

	@RequestMapping(value = "/add")
	public void add(@RequestBody Unit unit, HttpServletRequest request) {
		unit.setCreateUser(getAccount(request));
		unit.setCreateTime(getNow());
		unitService.save(unit);
	}

	@RequestMapping(value = "/edit/{id}")
	public Unit findById(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		return unitService.findById(id);
	}

	@RequestMapping(value = "/edit")
	public void edit(@RequestBody Unit unit, HttpServletRequest request) {
		unit.setUpdateUser(getAccount(request));
		unit.setUpdateTime(getNow());
		unitService.update(unit);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		unitService.delete(id);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			unitService.delete(id);
		}
	}

	@RequestMapping(value = "/findByCategory/{categoryCode}")
	public List<Unit> findByCategory(@PathVariable("categoryCode") String categoryCode) {
		// TODO Auto-generated method stub
		return unitService.findByCategory(categoryCode);
	}

	@RequestMapping(value = "/findAll")
	public List<Unit> findAll() {
		// TODO Auto-generated method stub
		return unitService.findAll();
	}
}
