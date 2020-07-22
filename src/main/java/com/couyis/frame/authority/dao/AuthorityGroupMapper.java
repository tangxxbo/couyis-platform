package com.couyis.frame.authority.dao;

import java.util.List;

import com.couyis.frame.authority.bean.AuthorityGroupBean;
import com.couyis.frame.authority.pojo.AuthorityGroup;

public interface AuthorityGroupMapper {
	Integer findCount(AuthorityGroupBean authorityGroupBean);

	List<AuthorityGroup> findPage(AuthorityGroupBean authorityGroupBean);

	List<AuthorityGroup> findAll();

	AuthorityGroup findById(String id);

	int deleteById(String id);

	int save(AuthorityGroup menu);

	int update(AuthorityGroup menu);
}
