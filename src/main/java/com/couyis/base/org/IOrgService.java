package com.couyis.base.org;

import java.util.List;

import com.couyis.base.org.pojo.Org;
import com.couyis.common.web.IService;

public interface IOrgService extends IService<Org> {
	public List<Org> findTree();

//	public String findTreeLookUp();

	public List<Org> findByParentId(String parentId);

	public List<Org> findChildById(String id);
	
	public List<Org> findAll();

}
