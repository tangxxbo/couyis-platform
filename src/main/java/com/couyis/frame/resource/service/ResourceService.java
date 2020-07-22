package com.couyis.frame.resource.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.resource.IResourceService;
import com.couyis.frame.resource.bean.ResourceBean;
import com.couyis.frame.resource.dao.ResourceMapper;
import com.couyis.frame.resource.pojo.Resource;

@Service
public class ResourceService implements IResourceService {
	@javax.annotation.Resource
	private ResourceMapper resourceMapper;

	@Transactional
	public void save(Resource resource) {
		// TODO Auto-generated method stub
		resource.setId(UUIDUtil.get());
		resourceMapper.save(resource);
	}

	@Transactional
	public void update(Resource resource) {
		// TODO Auto-generated method stub
		resourceMapper.update(resource);
	}

	public Resource findById(String id) {
		// TODO Auto-generated method stub
		return resourceMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		resourceMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		pageBean.setTotal(resourceMapper.findCount((ResourceBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(resourceMapper.findPage((ResourceBean) pageBean));
		return pageBean;
	}

	public List<Resource> findAll() {
		// TODO Auto-generated method stub
		return resourceMapper.findAll();
	}

}
