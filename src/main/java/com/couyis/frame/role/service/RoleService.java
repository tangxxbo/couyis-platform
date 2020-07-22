package com.couyis.frame.role.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.authority.IAuthorityGroupService;
import com.couyis.frame.authority.IAuthorityService;
import com.couyis.frame.authority.pojo.Authority;
import com.couyis.frame.role.IRoleService;
import com.couyis.frame.role.bean.RoleBean;
import com.couyis.frame.role.dao.RoleMapper;
import com.couyis.frame.role.pojo.Role;

@Service
public class RoleService implements IRoleService {
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private IAuthorityService authorityService;
	@Resource
	private IAuthorityGroupService authorityGroupService;
	
	@Transactional
	public void save(Role role) {
		// TODO Auto-generated method stub
		role.setId(UUIDUtil.get());
		roleMapper.save(role);
		for (Authority authority : role.getAuthoritys()) {
			roleMapper.saveAuthority(role.getId(), authority.getId());
		}
		
//		for(AuthorityGroup authorityGroup :role.getAuthorityGroups()) {
//			roleMapper.saveAuthorityGroup(role.getId(), authorityGroup.getId());
//		}
	}

	@Transactional
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleMapper.deleteAuthorityGroupById(role.getId());
		roleMapper.deleteAuthorityById(role.getId());
		roleMapper.update(role);
		for (Authority authority : role.getAuthoritys()) {
			roleMapper.saveAuthority(role.getId(), authority.getId());
		}
		
//		for(AuthorityGroup authorityGroup :role.getAuthorityGroups()) {
//			roleMapper.saveAuthorityGroup(role.getId(), authorityGroup.getId());
//		}
	}

	public List<String> findAuthorityByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findAuthorityByRoleId(roleId);
	}

	public Role findById(String id) {
		// TODO Auto-generated method stub
		Role role = roleMapper.findById(id);
		role.setAuthoritys(authorityService.findByRoleId(id));
//		role.setAuthorityGroups(authorityGroupService.findByRoleId(id));
		return role;
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		roleMapper.deleteAuthorityGroupById(id);
		roleMapper.deleteAuthorityById(id);
		roleMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(roleMapper.findCount((RoleBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(roleMapper.findPage((RoleBean) pageBean));
		return pageBean;
	}

	public List<Role> findByAccount(String account) {
		// TODO Auto-generated method stub
		return roleMapper.findByAccount(account);
	}

	public List<Role> findSuggest(String keyword) {
		// TODO Auto-generated method stub
		return roleMapper.findSuggest(keyword);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleMapper.findAll();
	}

}
