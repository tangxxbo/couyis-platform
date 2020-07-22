package com.couyis.base.classification;

import java.util.Date;
import java.util.List;

import com.couyis.base.classification.pojo.Classification;
import com.couyis.common.web.IService;

public interface IClassificationService extends IService<Classification> {
	public void delete(String id, String deleteUser, Date deleteTime);

	public Classification findByCode(String code);
	
	public List<Classification> findByCategory(String category);
}
