package com.couyis.base.classification.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.classification.bean.ClassificationBean;
import com.couyis.base.classification.pojo.Classification;

public interface ClassificationMapper {
	Integer findCount(ClassificationBean classificationBean);

	List<Classification> findPage(ClassificationBean classificationBean);

	List<Classification> findAll();

	Classification findById(String id);

	int deleteById(String id);

	int save(Classification classification);

	int update(Classification classification);

	public Classification findByCode(@Param("code") String code);

	public List<Classification> findByCategory(@Param("category") String category);
}
