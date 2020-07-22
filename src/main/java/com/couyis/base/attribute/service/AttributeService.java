package com.couyis.base.attribute.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.base.attribute.IAttributeService;
import com.couyis.base.attribute.bean.AttributeBean;
import com.couyis.base.attribute.dao.AttributeMapper;
import com.couyis.base.attribute.dao.AttributeValueMapper;
import com.couyis.base.attribute.pojo.Attribute;
import com.couyis.base.attribute.pojo.AttributeValue;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;

@Service
public class AttributeService implements IAttributeService {
	@Resource
	private AttributeMapper attributeMapper;
	@Resource
	private AttributeValueMapper attributeValueMapper;

	@Override
	@Transactional
	public void save(Attribute attribute) {
		// TODO Auto-generated method stub
		attribute.setId(UUIDUtil.get());

		for (AttributeValue attributeValue : attribute.getAttributeValues()) {
			attributeValue.setId(UUIDUtil.get());
			attributeValue.setAttributeId(attribute.getId());
			attributeValueMapper.save(attributeValue);
		}
		attributeMapper.save(attribute);

	}

	@Override
	@Transactional
	public void update(Attribute attribute) {
		// TODO Auto-generated method stub
		attributeValueMapper.deleteByAttributeId(attribute.getId());
		for (AttributeValue attributeValue : attribute.getAttributeValues()) {
			attributeValue.setId(UUIDUtil.get());
			attributeValue.setAttributeId(attribute.getId());
			attributeValueMapper.save(attributeValue);
		}
		attributeMapper.update(attribute);
	}

	@Override
	public Attribute findById(String id) {
		// TODO Auto-generated method stub
		Attribute attribute = attributeMapper.findById(id);
		attribute.setAttributeValues(attributeValueMapper.findByAttributeId(id));
		return attribute;
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		Attribute attribute = attributeMapper.findById(id);
		attribute.setIsDelete(true);
		attributeMapper.update(attribute);
	}

	@Override
	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(attributeMapper.findCount((AttributeBean) pageBean));
		PageBean.calculate(pageBean);
		List<Attribute> attributes = attributeMapper.findPage((AttributeBean) pageBean);
		pageBean.setList(attributes);
		return pageBean;
	}

	@Override
	@Transactional
	public void delete(String id, String deleteUser, Date deleteTime) {
		// TODO Auto-generated method stub
		Attribute attribute = attributeMapper.findById(id);
		attribute.setDeleteTime(deleteTime);
		attribute.setDeleteUser(deleteUser);
		attribute.setIsDelete(true);
		attributeMapper.update(attribute);
	}

	@Override
	public List<Attribute> findAll() {
		// TODO Auto-generated method stub
		return attributeMapper.findAll();
	}

}
