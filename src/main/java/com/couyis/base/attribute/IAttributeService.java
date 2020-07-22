package com.couyis.base.attribute;

import java.util.Date;
import java.util.List;

import com.couyis.base.attribute.pojo.Attribute;
import com.couyis.common.web.IService;

public interface IAttributeService extends IService<Attribute> {
	public void delete(String id, String deleteUser, Date deleteTime);
	public List<Attribute> findAll();
}
