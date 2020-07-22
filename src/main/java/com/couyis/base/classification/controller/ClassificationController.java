package com.couyis.base.classification.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.classification.IClassificationService;
import com.couyis.base.classification.bean.ClassificationBean;
import com.couyis.base.classification.pojo.Classification;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/classification")
public class ClassificationController extends BaseController {
	@Resource
	private IClassificationService classificationService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody ClassificationBean pageBean) {
		return classificationService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Classification classification, HttpServletRequest request) {
		classification.setCreateUser(getAccount(request));
		classification.setCreateTime(getNow());
		classificationService.save(classification);
	}

	@RequestMapping(value = "/edit/{id}")
	public Classification edit(@PathVariable("id") String id) {
		return classificationService.findById(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Classification classification, HttpServletRequest request) {
		classification.setUpdateUser(getAccount(request));
		classification.setUpdateTime(getNow());
		classificationService.update(classification);
	}

	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids, HttpServletRequest request) {
		for (String id : ids) {
			classificationService.delete(id, getAccount(request), getNow());
		}
	}

	@RequestMapping(value = "/findByCode")
	public Classification findByCode(@RequestBody String code) {
		Classification classification = classificationService.findByCode(code);
		return classification;
	}

	@RequestMapping(value = "/findByCategory")
	public List<Classification> findByCategory(String category) {
		return classificationService.findByCategory(category);
	}
}
