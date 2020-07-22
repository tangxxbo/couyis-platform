package com.couyis.base.file.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.file.IFileService;
import com.couyis.base.file.bean.FileBean;
import com.couyis.base.file.pojo.File;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;

@RestController
@RequestMapping("/base/file")
public class FileController extends BaseController{
	@Resource
	public IFileService fileService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody FileBean pageBean) {
		return fileService.findPage(pageBean);
	}

	@RequestMapping(value = "/add")
	public void add(@RequestBody File file, HttpServletRequest request) {
		file.setCreateUser(getAccount(request));
		file.setCreateTime(getNow());
		fileService.save(file);
	}

	@RequestMapping(value = "/edit/{id}")
	public File edit(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		return fileService.findById(id);
	}

	@RequestMapping(value = "/edit")
	public void edit(@RequestBody File file) {
		// TODO Auto-generated method stub
		fileService.update(file);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		fileService.delete(id);
	}

}
