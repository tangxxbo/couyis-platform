package com.couyis.frame.role;

import java.util.List;

import com.couyis.common.web.IService;
import com.couyis.frame.role.pojo.Role;

public interface IRoleService extends IService<Role> {
	List<String> findAuthorityByRoleId(String roleId);
	
	List<Role> findByAccount(String account);
	
	List<Role> findSuggest(String keyword);
	
	List<Role> findAll();
}
