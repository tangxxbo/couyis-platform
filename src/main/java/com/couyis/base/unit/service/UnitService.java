package com.couyis.base.unit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.base.unit.IUnitService;
import com.couyis.base.unit.bean.UnitBean;
import com.couyis.base.unit.dao.UnitMapper;
import com.couyis.base.unit.pojo.Unit;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;

@Service
public class UnitService implements IUnitService {
	@Resource
	private UnitMapper unitMapper;

	@Transactional
	public void save(Unit unit) {
		// TODO Auto-generated method stub
		unit.setId(UUIDUtil.get());
		unitMapper.save(unit);
	}

	@Transactional
	public void update(Unit unit) {
		// TODO Auto-generated method stub
		unitMapper.update(unit);
	}

	public Unit findById(String id) {
		// TODO Auto-generated method stub
		return unitMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		unitMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		pageBean.setTotal(unitMapper.findCount((UnitBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(unitMapper.findPage((UnitBean) pageBean));
		return pageBean;
	}


	@Override
	public List<Unit> findByCategory(String categoryCode) {
		// TODO Auto-generated method stub
		return unitMapper.findByCategory(categoryCode);
	}

	@Override
	public List<Unit> findAll() {
		// TODO Auto-generated method stub
		return unitMapper.findAll();
	}

}
