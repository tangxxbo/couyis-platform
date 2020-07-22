package com.couyis.base.unit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.unit.bean.UnitBean;
import com.couyis.base.unit.pojo.Unit;

public interface UnitMapper {
	Integer findCount(UnitBean unitBean);

	List<Unit> findPage(UnitBean unitBean);

	List<Unit> findAll();

	Unit findById(String id);

	List<Unit> findByCategory(@Param("categoryCode") String categoryCode);

	int deleteById(String id);

	int save(Unit unit);

	int update(Unit unit);
}
