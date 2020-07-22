package com.couyis.frame.account;

import java.util.List;

import com.couyis.common.web.IService;
import com.couyis.frame.account.pojo.Account;

public interface IAccountService extends IService<Account> {
	/**
	 * 用户登录判断
	 * 
	 * @param account
	 * @param password
	 * @param category
	 * @return
	 */
	public Boolean login(String account, String password);

	/**
	 * 检查帐号是否存在 true存在
	 * 
	 * @param account
	 * @return
	 */
	public Boolean checkAccount(String account);

	/**
	 * 获取该用户所有的菜单
	 * 
	 * @param account
	 * @return
	 */
//	public List<AccountMenuBean> findMenu(String secret, String account);

	/**
	 * 帐号查询帐号信息
	 * 
	 * @param account
	 * @return
	 */
	public Account findByAccount(String account);

	/**
	 * 保存当前实体
	 * 
	 * @param t
	 */
	// public void save(Account account, List<String> roleIds, List<String>
	// authorityIds);

	/**
	 * 更新当前实体
	 * 
	 * @param t
	 */
	// public void update(Account account, List<String> roleIds, List<String>
	// authorityIds);

	public List<Object> findResourceAuthority(String account);

	public List<Object> findDisplayAuthority(String account);
	
	public void chanagePassword(Account account);
}
