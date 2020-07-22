package com.couyis.frame.system;

import java.util.List;

import com.couyis.common.web.IService;

public interface ISystemService extends IService<com.couyis.frame.system.pojo.System> {

	List<com.couyis.frame.system.pojo.System> findSuggest(String keyword);

	List<com.couyis.frame.system.pojo.System> findAll();

}
