package com.couyis.frame.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.frame.role.bean.RoleBean;
import com.couyis.frame.role.pojo.Role;

public interface RoleMapper {
	Integer findCount(RoleBean roleBean);

	List<Role> findPage(RoleBean roleBean);

	List<Role> findAll();

	Role findById(String id);

	int deleteById(String id);

	int save(Role role);

	int update(Role role);

	int deleteAuthorityById(@Param("roleId") String roleId);
	
	int deleteAuthorityGroupById(@Param("roleId") String roleId);

	int saveAuthority(@Param("roleId") String roleId, @Param("authorityId") String authorityId);
	
	int saveAuthorityGroup(@Param("roleId") String roleId, @Param("authorityGroupId") String authorityGroupId);

	List<String> findAuthorityByRoleId(@Param("roleId") String roleId);
	
	List<Role> findByAccount(@Param("account")String account);
	
	List<Role> findSuggest(@Param("keyword")String keyword);

}
