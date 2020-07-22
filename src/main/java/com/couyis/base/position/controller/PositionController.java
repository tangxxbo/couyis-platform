package com.couyis.base.position.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.position.IPositionService;
import com.couyis.base.position.bean.PositionBean;
import com.couyis.base.position.pojo.Position;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/position")
public class PositionController extends BaseController{
	@Resource
	private IPositionService positionService;

	@RequestMapping(value = "/list")
	public PageBean findPage(@RequestBody PositionBean pageBean) {
		return positionService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Position postion, HttpServletRequest request) {
		postion.setCreateUser(getAccount(request));
		postion.setCreateTime(getNow());
		positionService.save(postion);
	}

	@RequestMapping(value = "/edit/{id}")
	public Position findById(@PathVariable("id") String id) {
		return positionService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Position postion, HttpServletRequest request) {
		postion.setUpdateUser(getAccount(request));
		postion.setUpdateTime(getNow());
		positionService.update(postion);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		positionService.delete(id);
	}
	
	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			positionService.delete(id);
		}
	}

//	@RequestMapping(value = "/saveOrgPosition")
//	public void saveOrgPosition(@RequestBody(required = false) String orgId,
//			@RequestBody(required = false) String positionId) {
//		positionService.saveOrgPosition(orgId, positionId);
//	}

	@RequestMapping(value = "/findByOrg/{orgId}")
	public List<Position> findByOrg(@PathVariable("orgId") String orgId) {
		return positionService.findByOrgId(orgId);
	}

//	@RequestMapping(value = "/deletePositionByOrgId")
//	public void deletePositionByOrgId(@RequestBody(required = false) String orgId) {
//		positionService.deletePositionByOrgId(orgId);
//	}

	@RequestMapping(value = "/findAll")
	public List<Position> findAll() {
		return positionService.findAll();
	}

}
