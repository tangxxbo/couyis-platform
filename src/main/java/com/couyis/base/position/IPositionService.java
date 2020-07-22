package com.couyis.base.position;

import java.util.List;

import com.couyis.base.position.pojo.Position;
import com.couyis.common.web.IService;

public interface IPositionService extends IService<Position> {
	public void saveOrgPosition(String orgId, String positionId);

	public List<Position> findByOrgId(String orgId);

	public void deletePositionByOrgId(String orgId);
	
	public List<Position> findAll();
}
