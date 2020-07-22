package com.couyis.frame.authority.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.authority.IAuthorityGroupService;
import com.couyis.frame.authority.bean.AuthorityGroupBean;
import com.couyis.frame.authority.dao.AuthorityGroupMapper;
import com.couyis.frame.authority.pojo.AuthorityGroup;

@Service
public class AuthorityGroupService implements IAuthorityGroupService {
	@Resource
	private AuthorityGroupMapper authorityGroupMapper;

	@Transactional
	public void save(AuthorityGroup authorityGroup) {
		// TODO Auto-generated method stub
		authorityGroup.setId(UUIDUtil.get());
		authorityGroupMapper.save(authorityGroup);
	}

	@Transactional
	public void update(AuthorityGroup authorityGroup) {
		// TODO Auto-generated method stub
		authorityGroupMapper.update(authorityGroup);
	}

	public AuthorityGroup findById(String id) {
		// TODO Auto-generated method stub
		return authorityGroupMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		authorityGroupMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(authorityGroupMapper.findCount((AuthorityGroupBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(authorityGroupMapper.findPage((AuthorityGroupBean) pageBean));
		return pageBean;
	}

	@Override
	public List<AuthorityGroup> findAll() {
		// TODO Auto-generated method stub
		return authorityGroupMapper.findAll();
	}
}
