package com.couyis.frame.resource;

import java.util.List;

import com.couyis.common.web.IService;
import com.couyis.frame.resource.pojo.Resource;

public interface IResourceService extends IService<Resource> {
	public List<Resource> findAll();
	
}
