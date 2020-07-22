package com.couyis.frame.log.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.log.IAccessLogService;
import com.couyis.frame.log.bean.AccessLogBean;
import com.couyis.frame.log.dao.AccessLogMapper;
import com.couyis.frame.log.pojo.AccessLog;

@Service
public class AccessLogService implements IAccessLogService {
	@Resource
	private AccessLogMapper accessLogMapper;

	@Override
	public void save(AccessLog log) {
		// TODO Auto-generated method stub
		log.setId(UUIDUtil.get());
		accessLogMapper.save(log);
	}

	@Override
	public void update(AccessLog log) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccessLog findById(String id) {
		// TODO Auto-generated method stub
		return accessLogMapper.findById(id);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		accessLogMapper.deleteById(id);
	}

	@Override
	public PageBean findPage(PageBean pageBean) {
		pageBean.setTotal(accessLogMapper.findCount((AccessLogBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(accessLogMapper.findPage((AccessLogBean) pageBean));
		return pageBean;
	}

}
