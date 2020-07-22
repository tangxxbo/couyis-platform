package com.couyis.frame.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.system.ISystemService;
import com.couyis.frame.system.bean.SystemBean;
import com.couyis.frame.system.dao.SystemMapper;

@Service
public class SystemService implements ISystemService {
	@Resource
	private SystemMapper systemMapper;

	@Override
	@Transactional
	public void save(com.couyis.frame.system.pojo.System system) {
		// TODO Auto-generated method stub
		system.setId(UUIDUtil.get());
		systemMapper.save(system);
	}

	@Override
	@Transactional
	public void update(com.couyis.frame.system.pojo.System system) {
		// TODO Auto-generated method stub
		systemMapper.update(system);
	}

	@Override
	public com.couyis.frame.system.pojo.System findById(String id) {
		// TODO Auto-generated method stub
		return systemMapper.findById(id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		systemMapper.deleteById(id);
	}

	@Override
	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(systemMapper.findCount((SystemBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(systemMapper.findPage((SystemBean) pageBean));
		return pageBean;
	}

	public List<com.couyis.frame.system.pojo.System> findAll() {
		// TODO Auto-generated method stub
		return systemMapper.findAll();
	}

	public List<com.couyis.frame.system.pojo.System> findSuggest(String keyword) {
		// TODO Auto-generated method stub
		return systemMapper.findSuggest(keyword);
	}

}
