package com.couyis.base.dict.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.couyis.base.dict.IDictService;
import com.couyis.base.dict.bean.DictBean;
import com.couyis.base.dict.dao.DictMapper;
import com.couyis.base.dict.pojo.Dict;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;

@Service
public class DictService implements IDictService {
	@Resource
	private DictMapper dictMapper;

	@Transactional
	public void save(Dict dict) {
		// TODO Auto-generated method stub
		dict.setId(UUIDUtil.get());
		dictMapper.save(dict);
	}

	@Transactional
	public void update(Dict dict) {
		// TODO Auto-generated method stub
		dictMapper.update(dict);
	}

	public Dict findById(String id) {
		// TODO Auto-generated method stub
		return dictMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		dictMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(dictMapper.findCount((DictBean) pageBean));
		PageBean.calculate(pageBean);
		List<Dict> dicts = dictMapper.findPage((DictBean) pageBean);
		assemble(dicts);
		pageBean.setList(dicts);
		return pageBean;
	}
	
	private void assemble(List<Dict> dicts) {
		for (Dict dict : dicts) {
			List<Dict> temps = dictMapper.findByParentId(dict.getId());
			if (temps.size() > 0) {
				dict.setChildren(temps);
				assemble(temps);
			}			
		}
	}
	
	@Override
	public List<Dict> findAll() {
		// TODO Auto-generated method stub
		List<Dict> dicts = dictMapper.findByParentId(null);
		assemble(dicts);
		return dicts;
	}

	public List<Dict> findTree(String code) {
		List<Dict> dicts = null;
		if(!StringUtils.isEmpty(code)) {
			Dict ditc = dictMapper.findByCode(code);		
			dicts = dictMapper.findByParentId(ditc.getId());
		}else {
			dicts = dictMapper.findByParentId(null);
		}		
		for (Dict dict : dicts) {
			dict.setChildren(assembleTree(dict.getId()));
		}
		return dicts;
	}

	private List<Dict> assembleTree(String parentId) {
		List<Dict> dicts = dictMapper.findByParentId(parentId);
		if (dicts.size() <= 0) {
			return dicts;
		}
		for (Dict dict : dicts) {
			dict.setChildren(assembleTree(dict.getId()));
		}
		return dicts;
	}

	public List<Dict> findByParentId(String parentId) {
		// TODO Auto-generated method stub
		List<Dict> dicts = dictMapper.findByParentId(parentId);
		return dicts;
	}

	public List<Dict> findSuggest(String keyword, String parentCode) {
		// TODO Auto-generated method stub
		return dictMapper.findSuggest(keyword, parentCode);
	}

	public Dict findByCode(String code) {
		// TODO Auto-generated method stub
		return dictMapper.findByCode(code);
	}

	@Override
	public List<Dict> findSuggest2(String keyword, String parentId) {
		// TODO Auto-generated method stub
		return dictMapper.findSuggest2(keyword, parentId);
	}

	

}
