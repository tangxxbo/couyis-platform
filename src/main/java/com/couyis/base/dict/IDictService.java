package com.couyis.base.dict;

import java.util.List;

import com.couyis.base.dict.pojo.Dict;
import com.couyis.common.web.IService;

public interface IDictService extends IService<Dict> {
	public List<Dict> findTree(String code);
	
	public List<Dict> findAll();

//	public String findTreeLookUp(String code);

	public List<Dict> findByParentId(String parentId);

	public List<Dict> findSuggest(String keyword,String parentCode);

	public List<Dict> findSuggest2(String keyword,String parentId);
	
	public Dict findByCode(String code);
}
