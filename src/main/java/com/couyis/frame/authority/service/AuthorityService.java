package com.couyis.frame.authority.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.authority.IAuthorityService;
import com.couyis.frame.authority.bean.AuthorityBean;
import com.couyis.frame.authority.dao.AuthorityMapper;
import com.couyis.frame.authority.pojo.Authority;
import com.couyis.frame.resource.dao.ResourceMapper;
import com.couyis.frame.resource.pojo.Resource;
import com.couyis.frame.role.dao.RoleMapper;

@Service
public class AuthorityService implements IAuthorityService {
	@javax.annotation.Resource
	private AuthorityMapper authorityMapper;
	@javax.annotation.Resource
	private RoleMapper roleMapper;
	@javax.annotation.Resource
	private AuthorityGroupService authorityGroupService;
	@javax.annotation.Resource
	private ResourceMapper resourceMapper;

	public Authority findById(String id) {
		// TODO Auto-generated method stub
		Authority authority = authorityMapper.findById(id);
		authority.setResources(resourceMapper.findResourceByAuthorityId(id));
		return authority;
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		authorityMapper.deleteResourceById(id);
		authorityMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(authorityMapper.findCount((AuthorityBean) pageBean));
		PageBean.calculate(pageBean);
		List<Authority> authoritys = authorityMapper.findPage((AuthorityBean) pageBean);
		for (Authority authority : authoritys) {
			authority.setResources(resourceMapper.findResourceByAuthorityId(authority.getId()));
		}
		pageBean.setList(authoritys);
		return pageBean;
	}

	@Transactional
	public void save(Authority authority) {
		// TODO Auto-generated method stub
		authority.setId(UUIDUtil.get());
		authorityMapper.save(authority);
		for (Resource resource : authority.getResources()) {
			authorityMapper.saveResource(authority.getId(), resource.getId());
		}
	}

	@Transactional
	public void update(Authority authority) {
		// TODO Auto-generated method stub
		authorityMapper.update(authority);
		authorityMapper.deleteResourceById(authority.getId());
		for (Resource resource : authority.getResources()) {
			authorityMapper.saveResource(authority.getId(), resource.getId());
		}
	}

	public List<Resource> findResourceByAuthorityId(String authorityId) {
		// TODO Auto-generated method stub
		return resourceMapper.findResourceByAuthorityId(authorityId);
	}
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityMapper.findAll();
	}

	public List<Authority> findByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return authorityMapper.findByRoleId(roleId);
	}

	public List<Authority> findByAccount(String account) {
		// TODO Auto-generated method stub
		return authorityMapper.findByAccount(account);
	}

	public List<Authority> findSuggest(String authgrpId, String keyword) {
		// TODO Auto-generated method stub
		return authorityMapper.findSuggest(authgrpId, keyword);
	}

}
