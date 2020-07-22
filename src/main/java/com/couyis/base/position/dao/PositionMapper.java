package com.couyis.base.position.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.position.bean.PositionBean;
import com.couyis.base.position.pojo.Position;

public interface PositionMapper {
	Integer findCount(PositionBean positionBean);

	List<Position> findPage(PositionBean positionBean);

	List<Position> findAll();

	Position findById(String id);

	int deleteById(String id);

	int save(Position position);

	int update(Position position);

	int saveOrgPosition(@Param("orgId") String orgId, @Param("positionId") String positionId);

	List<Position> findByOrgId(@Param("orgId") String orgId);

	int deletePositionByOrgId(@Param("orgId") String orgId);
}
