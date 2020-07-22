package com.couyis.base.dict.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.dict.IDictService;
import com.couyis.base.dict.bean.DictBean;
import com.couyis.base.dict.pojo.Dict;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/dict")
public class DictController extends BaseController {
	@Resource
	private IDictService dictService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody DictBean pageBean) {
		return dictService.findPage(pageBean);
	}

	@RequestMapping(value = "/add")
	public void add(@RequestBody Dict dict, HttpServletRequest request) {
		dict.setCreateUser(getAccount(request));
		dict.setCreateTime(getNow());
		dictService.save(dict);
	}

	@RequestMapping(value = "/edit/{id}")
	public Dict edit(@PathVariable("id") String id) {
		return dictService.findById(id);
	}

	@RequestMapping(value = "/edit")
	public void edit(@RequestBody Dict dict, HttpServletRequest request) {
		dict.setUpdateUser(getAccount(request));
		dict.setUpdateTime(getNow());
		dictService.update(dict);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		dictService.delete(id);
	}

	@RequestMapping(value = "/delete")
	public void delete(@RequestBody String[] ids) {
		for (String id : ids) {
			dictService.delete(id);
		}
	}

	@RequestMapping(value = "/findTree")
	public List<Dict> findTree(@RequestBody(required = false) String code) {
		return dictService.findTree(code);
	}

	@RequestMapping(value = "/findAll")
	public List<Dict> findAll() {
		return dictService.findAll();
	}

//	@RequestMapping(value = "/findTreeLookUp")
//	public String findTreeLookUp(@RequestBody(required = false) String code) {
//		return dictService.findTreeLookUp(code);
//	}

	@RequestMapping(value = "/findByParentId")
	public List<Dict> findByParentId(@RequestBody(required = false) String parentId) {
		return dictService.findByParentId(parentId);
	}

	@RequestMapping(value = "/findSuggest")
	public List<Dict> findSuggest(String keyword, String parentCode) {
		return dictService.findSuggest(keyword, parentCode);
	}

	@RequestMapping(value = "/findSuggest2")
	public List<Dict> findSuggest2(String keyword, String parentId) {
		return dictService.findSuggest2(keyword, parentId);
	}

	@RequestMapping(value = "/findByParentCode/{code}")
	public List<Dict> findByParentCode(@PathVariable("code") String code) {
		Dict dict = dictService.findByCode(code);
		return dictService.findByParentId(dict.getId());
	}

	@RequestMapping(value = "/findByCode")
	public List<Dict> findByCode(@RequestBody(required = false) String code) {
		Dict dict = dictService.findByCode(code);
		return dictService.findByParentId(dict.getId());
	}
}
