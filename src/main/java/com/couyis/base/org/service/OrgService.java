package com.couyis.base.org.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.base.org.IOrgService;
import com.couyis.base.org.bean.OrgBean;
import com.couyis.base.org.dao.OrgMapper;
import com.couyis.base.org.pojo.Org;
import com.couyis.base.position.IPositionService;
import com.couyis.base.position.pojo.Position;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;

@Service
public class OrgService implements IOrgService {
	@Resource
	private OrgMapper orgMapper;
	@Resource
	private IPositionService positionService;

	@Transactional
	public void save(Org org) {
		// TODO Auto-generated method stub
		org.setId(UUIDUtil.get());
		if (StringUtils.isEmpty(org.getParentId())) {
			org.setParentId(null);
		}
		orgMapper.save(org);
		for (Position position : org.getPositions()) {
			positionService.saveOrgPosition(org.getId(), position.getId());
		}		
	}

	@Transactional
	public void update(Org org) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(org.getParentId())) {
			org.setParentId(null);
		}
		positionService.deletePositionByOrgId(org.getId());
		for (Position position : org.getPositions()) {
			positionService.saveOrgPosition(org.getId(), position.getId());
		}
		orgMapper.update(org);
	}

	public Org findById(String id) {
		// TODO Auto-generated method stub
		Org org = orgMapper.findById(id);
		org.setPositions(positionService.findByOrgId(id));
		return org;
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		positionService.deletePositionByOrgId(id);
		orgMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(orgMapper.findCount((OrgBean) pageBean));
		PageBean.calculate(pageBean);
		List<Org> orgs = orgMapper.findPage((OrgBean) pageBean);
		assemble(orgs);
		pageBean.setList(orgs);
		return pageBean;
	}
	
	private void assemble(List<Org> orgs) {
		for (Org org : orgs) {
			List<Org> temps = orgMapper.findByParentId(org.getId());
			if (temps.size() > 0) {
				org.setChildren(temps);
				assemble(temps);
			}			
		}
	}
	
	@Override
	public List<Org> findAll() {
		List<Org> orgs = orgMapper.findByParentId(null);
		assemble(orgs);
		return orgs;
	}

//	public List<ZtreeBean> findTree(String context) {
//		// TODO Auto-generated method stub
//		List<Org> orgs = orgMapper.findAll();
//		List<ZtreeBean> ztreeBeans = new ArrayList<ZtreeBean>();
//
//		ZtreeBean top = new ZtreeBean();
//		top.setId(null);
//		top.setName("组织结构");
//		top.setRel("jbsxBox_org");
//		top.setTarget("ajax");
//		top.setUrl(context + "/base/org/list");
//		top.setpId("");
//		top.setOpen(true);
//		ztreeBeans.add(top);
//		for (Org org : orgs) {
//			ZtreeBean ztreeBean = new ZtreeBean();
//			ztreeBean.setId(org.getId());
//			ztreeBean.setName(org.getName());
//			ztreeBean.setRel("jbsxBox_org");
//			ztreeBean.setTarget("ajax");
//			ztreeBean.setUrl(context + "/base/org/list?parentId=" + org.getId());
//			ztreeBean.setpId(org.getParentId());
//			ztreeBean.setOpen(true);
//			ztreeBeans.add(ztreeBean);
//		}
//		return ztreeBeans;
//	}

	public List<Org> findTree() {
		List<Org> orgs = orgMapper.findByParentId(null);
		for (Org org : orgs) {
			org.setChildren(assembleTree(org.getId()));
		}
		return orgs;
	}

	private List<Org> assembleTree(String parentId) {
		List<Org> orgs = orgMapper.findByParentId(parentId);
		if (orgs.size() <= 0) {
			return null;
		}
		for (Org org : orgs) {
			org.setChildren(assembleTree(org.getId()));
		}
		return orgs;
	}

//	public String findTreeLookUp() {
//		// TODO Auto-generated method stub
//		StringBuilder sbTrees = new StringBuilder();
//		List<Org> orgs = orgMapper.findByParentId(null);
//		sbTrees.append("<ul class=\"tree expand\">");
//		for (Org org : orgs) {
//			sbTrees.append("<li><a href=\"javascript:\" onclick=\"$.bringBack({id:'" + org.getId() + "',name:'"
//					+ org.getName() + "'})\">" + org.getName() + "</a>");
//			sbTrees.append(assembleTree(org.getId()));
//			sbTrees.append("</li>");
//		}
//		sbTrees.append("</ul>");
//		return sbTrees.toString();
//	}

//	private String assembleTree(String parentId) {
//		StringBuilder sbTrees = new StringBuilder();
//		List<Org> orgs = orgMapper.findByParentId(parentId);
//		if (orgs.size() <= 0) {
//			return sbTrees.toString();
//		}
//		sbTrees.append("<ul>");
//		for (Org org : orgs) {
//			sbTrees.append("<li><a href=\"javascript:\" onclick=\"$.bringBack({id:'" + org.getId() + "',name:'"
//					+ org.getName() + "'})\">" + org.getName() + "</a>");
//			sbTrees.append(assembleTree(org.getId()));
//			sbTrees.append("</li>");
//		}
//		sbTrees.append("</ul>");
//		return sbTrees.toString();
//	}

	public List<Org> findByParentId(String parentId) {
		// TODO Auto-generated method stub
		List<Org> orgs = orgMapper.findByParentId(parentId);
		return orgs;
	}

	public List<Org> findChildById(String id) {
		// TODO Auto-generated method stub
		List<Org> orgs = new ArrayList<Org>();
		List<Org> childs = orgMapper.findByParentId(id);
		for (Org org : childs) {
			orgs.add(org);
			orgs.addAll(findChildById(org.getId()));
		}
		return orgs;
	}

	
}
