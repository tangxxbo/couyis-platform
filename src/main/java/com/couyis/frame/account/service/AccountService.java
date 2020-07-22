package com.couyis.frame.account.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.MD5Util;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.account.IAccountService;
import com.couyis.frame.account.bean.AccountBean;
import com.couyis.frame.account.dao.AccountMapper;
import com.couyis.frame.account.enums.AccountCategory;
import com.couyis.frame.account.pojo.Account;
import com.couyis.frame.authority.IAuthorityGroupService;
import com.couyis.frame.authority.dao.AuthorityMapper;
import com.couyis.frame.authority.pojo.Authority;
import com.couyis.frame.role.dao.RoleMapper;
import com.couyis.frame.role.pojo.Role;

@Service
public class AccountService implements IAccountService {
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private IAuthorityGroupService authorityGroupService;
	@Resource
	private AuthorityMapper authorityMapper;

	@Transactional
	public void save(Account account) {
		// TODO Auto-generated method stub
		account.setCategory(AccountCategory.COMMON);
		account.setPassword(MD5Util.MD5(account.getPassword()));
		account.setId(UUIDUtil.get());
		accountMapper.save(account);

		for (Authority authority : account.getAuthoritys()) {
			accountMapper.saveAccountAuthority(account.getAccount(), authority.getId());
		}

		for (Role role : account.getRoles()) {
			accountMapper.saveAccountRole(account.getAccount(), role.getId());
		}
	}
	@Transactional
	public void chanagePassword(Account account) {
		account.setPassword(MD5Util.MD5(account.getPassword()));
		accountMapper.update(account);
	}

	@Transactional
	public void update(Account account) {
		// TODO Auto-generated method stub
		accountMapper.deleteAuthorityByAccount(account.getAccount());
		accountMapper.deleteRoleByAccount(account.getAccount());
		//accountMapper.update(account);
		for (Authority authority : account.getAuthoritys()) {
			accountMapper.saveAccountAuthority(account.getAccount(), authority.getId());
		}

		for (Role role : account.getRoles()) {
			accountMapper.saveAccountRole(account.getAccount(), role.getId());
		}
	}

	public Account findById(String id) {
		// TODO Auto-generated method stub
		Account account = accountMapper.findById(id);
		account.setRoles(roleMapper.findByAccount(account.getAccount()));
		account.setAuthoritys(authorityMapper.findByAccount(account.getAccount()));
		return account;
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		accountMapper.deleteAuthorityByAccount(findById(id).getAccount());
		accountMapper.deleteRoleByAccount(findById(id).getAccount());
		accountMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(accountMapper.findCount((AccountBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(accountMapper.findPage((AccountBean) pageBean));
		return pageBean;
	}

	public Boolean login(String account, String password) {
		// TODO Auto-generated method stub
		password = MD5Util.MD5(password);
		Account acc = accountMapper.findByAccount(account);
		if (acc == null) {
			return false;
		}
		if (password.equals(acc.getPassword())) {
			return true;
		}
		return false;
	}

	public Boolean checkAccount(String account) {
		Account acc = accountMapper.findByAccount(account);
		return acc != null;
	}

	public Account findByAccount(String account) {
		// TODO Auto-generated method stub
		Account acc = accountMapper.findByAccount(account);
		acc.setRoles(roleMapper.findByAccount(acc.getAccount()));
		acc.setAuthoritys(authorityMapper.findByAccount(acc.getAccount()));
		return acc;
	}

	public List<Object> findResourceAuthority(String account) {
//		StringBuilder sbResources = new StringBuilder();
		List<Object> resources = accountMapper.findResourceAuthority(account);
//		for (String string : resources) {
//			sbResources.append(string);
//			sbResources.append(",");
//		}
		return resources;
	}

	public List<Object> findDisplayAuthority(String account) {
//		StringBuilder sbAuthority = new StringBuilder();
		List<Object> authoritys = accountMapper.findDisplayAuthority(account);
//		for (String string : authoritys) {
//			sbAuthority.append(string);
//			sbAuthority.append(",");
//		}
		return authoritys;
	}
}
