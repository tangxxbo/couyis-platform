package com.couyis.base.dict.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.dict.bean.DictBean;
import com.couyis.base.dict.pojo.Dict;

public interface DictMapper {
	Integer findCount(DictBean dictBean);

	List<Dict> findPage(DictBean dictBean);

	List<Dict> findAll();

	List<Dict> findByParentId(@Param("parentId") String parentId);
	
	Dict findByCode(@Param("code") String code);
	
	Dict findById(String id);

	int deleteById(String id);

	int save(Dict dict);

	int update(Dict dict);

	public List<Dict> findSuggest(@Param("keyword") String keyword,@Param("parentCode") String parentCode);
	
	public List<Dict> findSuggest2(@Param("keyword") String keyword,@Param("parentId") String parentId);
}
