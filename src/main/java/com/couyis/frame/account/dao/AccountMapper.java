package com.couyis.frame.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.frame.account.bean.AccountBean;
import com.couyis.frame.account.bean.ItemBean;
import com.couyis.frame.account.pojo.Account;

/**
 * 菜单表数据库操作
 * 
 * @author 邓放平
 *
 */
public interface AccountMapper {

	Integer findCount(AccountBean accountBean);

	List<Account> findPage(AccountBean accountBean);

	Account findById(String id);

	Account findByAccount(@Param("account")String account);

	int deleteById(String id);

	int save(Account account);

	int update(Account account);

	public List<Object> findResourceAuthority(@Param("account")String account);

	public List<Object> findDisplayAuthority(@Param("account") String account);

	int deleteRoleByAccount(@Param("account") String account);

	int saveAccountRole(@Param("account") String account, @Param("roleId") String roleId);

	List<String> findRoleByAccount(@Param("account") String account);

	int deleteAuthorityByAccount(@Param("account") String account);

	int saveAccountAuthority(@Param("account") String account, @Param("authorityId") String authorityId);

	List<String> findAuthorityByAccount(@Param("account") String account);

	List<ItemBean> findFeatureAuthority(@Param("account") String account);
}
