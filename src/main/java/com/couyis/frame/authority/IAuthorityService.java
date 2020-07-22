package com.couyis.frame.authority;

import java.util.List;

import com.couyis.common.web.IService;
import com.couyis.frame.authority.pojo.Authority;
import com.couyis.frame.resource.pojo.Resource;

public interface IAuthorityService extends IService<Authority> {

	public List<Resource> findResourceByAuthorityId(String authorityId);

	public List<Authority> findAll();

	public List<Authority> findByRoleId(String roleId);
	
	public List<Authority> findByAccount(String account);
	
	
	public List<Authority> findSuggest(String authgrpId,String keyword);
}
