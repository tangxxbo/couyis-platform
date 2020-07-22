package com.couyis.frame.resource.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.frame.resource.bean.ResourceBean;
import com.couyis.frame.resource.pojo.Resource;

/**
 * 系统访问资源表数据库操作
 * 
 * @author 邓放平
 *
 */
public interface ResourceMapper {

	Integer findCount(ResourceBean resourceBean);

	List<Resource> findPage(ResourceBean resourceBean);

	List<Resource> findAll();

	Resource findById(String id);

	int deleteById(String id);

	int save(Resource resource);

	int update(Resource resource);
	
	List<Resource> findResourceByAuthorityId(@Param("authorityId") String authorityId);
}