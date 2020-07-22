package com.couyis.base.file.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.base.file.IFileService;
import com.couyis.base.file.bean.FileBean;
import com.couyis.base.file.dao.FileMapper;
import com.couyis.base.file.pojo.File;
import com.couyis.common.web.bean.PageBean;

@Service
public class FileService implements IFileService {
	@Resource
	private FileMapper fileMapper;

	@Transactional
	public void save(File file) {
		// TODO Auto-generated method stub
		fileMapper.save(file);
	}

	@Transactional
	public void update(File file) {
		// TODO Auto-generated method stub
		fileMapper.update(file);
	}

	public File findById(String id) {
		// TODO Auto-generated method stub
		return fileMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		fileMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(fileMapper.findCount((FileBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(fileMapper.findPage((FileBean) pageBean));
		return pageBean;
	}

}
