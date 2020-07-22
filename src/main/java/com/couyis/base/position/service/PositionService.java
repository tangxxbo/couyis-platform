package com.couyis.base.position.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.base.position.IPositionService;
import com.couyis.base.position.bean.PositionBean;
import com.couyis.base.position.dao.PositionMapper;
import com.couyis.base.position.pojo.Position;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;

@Service
public class PositionService implements IPositionService {
	@Resource
	private PositionMapper positionMapper;

	@Transactional
	public void save(Position postion) {
		// TODO Auto-generated method stub
		postion.setId(UUIDUtil.get());
		positionMapper.save(postion);
	}

	@Transactional
	public void update(Position postion) {
		// TODO Auto-generated method stub
		positionMapper.update(postion);
	}

	public Position findById(String id) {
		// TODO Auto-generated method stub
		return positionMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		positionMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(positionMapper.findCount((PositionBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(positionMapper.findPage((PositionBean) pageBean));
		return pageBean;
	}

	public void saveOrgPosition(String orgId, String positionId) {
		// TODO Auto-generated method stub
		positionMapper.saveOrgPosition(orgId, positionId);
	}

	public List<Position> findByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return positionMapper.findByOrgId(orgId);
	}

	public void deletePositionByOrgId(String orgId) {
		// TODO Auto-generated method stub
		positionMapper.deletePositionByOrgId(orgId);
	}

	@Override
	public List<Position> findAll() {
		// TODO Auto-generated method stub
		return positionMapper.findAll();
	}

}
