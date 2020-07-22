package com.couyis.base.attribute.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.attribute.pojo.AttributeValue;

public interface AttributeValueMapper {

	List<AttributeValue> findByAttributeId(@Param("attributeId") String attributeId);

	int deleteByAttributeId(@Param("attributeId") String attributeId);

	int save(AttributeValue attributeValue);

	int update(AttributeValue attributeValue);
}
