package com.couyis.base.attribute.dao;

import java.util.List;

import com.couyis.base.attribute.bean.AttributeBean;
import com.couyis.base.attribute.pojo.Attribute;

public interface AttributeMapper {
	Integer findCount(AttributeBean attributeBean);

	List<Attribute> findPage(AttributeBean attributeBean);

	List<Attribute> findAll();

	Attribute findById(String id);

	int deleteById(String id);

	int save(Attribute attribute);

	int update(Attribute attribute);
}
