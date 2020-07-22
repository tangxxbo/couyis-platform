package com.couyis.frame.authority;

import java.util.List;

import com.couyis.common.web.IService;
import com.couyis.frame.authority.pojo.AuthorityGroup;

public interface IAuthorityGroupService extends IService<AuthorityGroup> {
	public List<AuthorityGroup> findAll();
}
