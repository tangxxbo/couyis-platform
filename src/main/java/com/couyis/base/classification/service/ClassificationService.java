package com.couyis.base.classification.service;
	
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.couyis.base.attribute.IAttributeService;
import com.couyis.base.attribute.pojo.Attribute;
import com.couyis.base.classification.IClassificationService;
import com.couyis.base.classification.bean.ClassificationBean;
import com.couyis.base.classification.dao.ClassificationAttributeMapper;
import com.couyis.base.classification.dao.ClassificationMapper;
import com.couyis.base.classification.pojo.Classification;
import com.couyis.base.classification.pojo.ClassificationAttribute;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;

@Service
public class ClassificationService implements IClassificationService {
	@Resource
	private ClassificationMapper classificationMapper;
	@Resource
	private ClassificationAttributeMapper classificationAttributeMapper;
	@Resource
	private IAttributeService attributeService;

	@Override
	public void save(Classification classification) {
		// TODO Auto-generated method stub
		classification.setId(UUIDUtil.get());
		for (ClassificationAttribute classificationAttribute : classification.getClassificationAttributes()) {
			classificationAttribute.setId(UUIDUtil.get());
			classificationAttribute.setClassificationId(classification.getId());
			classificationAttributeMapper.save(classificationAttribute);
		}
		classificationMapper.save(classification);
	}

	@Override
	public void update(Classification classification) {
		// TODO Auto-generated method stub
		classificationAttributeMapper.deleteByClassificationId(classification.getId());
		for (ClassificationAttribute classificationAttribute : classification.getClassificationAttributes()) {
			classificationAttribute.setId(UUIDUtil.get());
			classificationAttribute.setClassificationId(classification.getId());
			classificationAttributeMapper.save(classificationAttribute);
		}
		classificationMapper.update(classification);
	}

	@Override
	public Classification findById(String id) {
		// TODO Auto-generated method stub
		Classification classification = classificationMapper.findById(id);
		classification.setClassificationAttributes(classificationAttributeMapper.findByClassificationId(id));
		return classification;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Classification classification = classificationMapper.findById(id);
		classification.setIsDelete(true);
		classificationMapper.update(classification);
	}

	@Override
	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(classificationMapper.findCount((ClassificationBean) pageBean));
		PageBean.calculate(pageBean);
		List<Classification> classifications = classificationMapper.findPage((ClassificationBean) pageBean);
		pageBean.setList(classifications);
		return pageBean;
	}

	@Override
	public void delete(String id, String deleteUser, Date deleteTime) {
		// TODO Auto-generated method stub
		Classification classification = classificationMapper.findById(id);
		classification.setDeleteTime(deleteTime);
		classification.setDeleteUser(deleteUser);
		classification.setIsDelete(true);
		classificationMapper.update(classification);
	}

	@Override
	public Classification findByCode(String code) {
		// TODO Auto-generated method stub
		Classification classification = classificationMapper.findByCode(code);
		List<ClassificationAttribute> classificationAttributes = classificationAttributeMapper
				.findByClassificationId(classification.getId());

		for (ClassificationAttribute classificationAttribute : classificationAttributes) {
			Attribute attribute = attributeService.findById(classificationAttribute.getAttributeId());
			classificationAttribute.setAttribute(attribute);
		}

		classification.setClassificationAttributes(classificationAttributes);
		return classification;
	}

	@Override
	public List<Classification> findByCategory(String category) {
		// TODO Auto-generated method stub
		List<Classification> classification = classificationMapper.findByCategory(category);
		return classification;
	}

}
