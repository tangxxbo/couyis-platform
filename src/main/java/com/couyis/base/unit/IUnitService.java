package com.couyis.base.unit;

import java.util.List;

import com.couyis.base.unit.pojo.Unit;
import com.couyis.common.web.IService;

public interface IUnitService extends IService<Unit> {
	public List<Unit> findByCategory(String categoryCode);

	public List<Unit> findAll();
}
