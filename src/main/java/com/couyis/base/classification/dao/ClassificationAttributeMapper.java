package com.couyis.base.classification.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.classification.pojo.ClassificationAttribute;

public interface ClassificationAttributeMapper {

	List<ClassificationAttribute> findByClassificationId(@Param("classificationId") String classificationId);

	int deleteByClassificationId(@Param("classificationId") String classificationId);

	int save(ClassificationAttribute classificationAttribute);

	int update(ClassificationAttribute classificationAttribute);
}
