package com.couyis.frame.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.couyis.frame.system.pojo.System;
import com.couyis.frame.system.bean.SystemBean;

/**
 * 系统表数据库操作
 * 
 * @author 邓放平
 *
 */
public interface SystemMapper {

	Integer findCount(SystemBean systemBean);

	List<System> findPage(SystemBean SsystemBean);

	List<System> findAll();

	System findById(String id);

	int deleteById(String id);

	int save(System system);

	int update(System System);

	public List<System> findSuggest(@Param("keyword") String keyword);
}