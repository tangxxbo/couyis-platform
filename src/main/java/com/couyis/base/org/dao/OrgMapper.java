package com.couyis.base.org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.org.bean.OrgBean;
import com.couyis.base.org.pojo.Org;

public interface OrgMapper {
	Integer findCount(OrgBean orgBean);

	List<Org> findPage(OrgBean orgBean);

	List<Org> findAll();

	List<Org> findByParentId(@Param("parentId") String parentId);

	Org findById(String id);

	int deleteById(String id);

	int save(Org org);

	int update(Org org);	
}
