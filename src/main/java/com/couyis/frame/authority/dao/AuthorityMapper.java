package com.couyis.frame.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.frame.authority.bean.AuthorityBean;
import com.couyis.frame.authority.pojo.Authority;

public interface AuthorityMapper {
	Integer findCount(AuthorityBean authorityBean);

	List<Authority> findPage(AuthorityBean authorityBean);

	List<Authority> findAll();

	Authority findById(String id);

	List<Authority> findByGroupId(@Param("groupId") String groupId);

	List<String> findResourceByAuthorityId(@Param("authorityId") String authorityId);

	int deleteById(String id);

	int deleteResourceById(@Param("authorityId") String authorityId);

	int saveResource(@Param("authorityId") String authorityId, @Param("resourceId") String resourceId);

	int save(Authority authority);

	int update(Authority authority);

	List<String> findFeatureByAuthorityId(@Param("authorityId") String authorityId);

	int deleteFeatureById(@Param("authorityId") String authorityId);

	int saveFeature(@Param("authorityId") String authorityId, @Param("featureId") String featureId);
	
	List<Authority> findByRoleId(@Param("roleId")String roleId);
	
	List<Authority> findByAccount(@Param("account")String account);
	
	List<Authority> findSuggest(@Param("authgrpId")String authgrpId, @Param("keyword")String keyword);
}
