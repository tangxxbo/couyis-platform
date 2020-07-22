package com.couyis.base.rule.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.rule.bean.RuleBean;
import com.couyis.base.rule.pojo.Rule;

public interface RuleMapper {
	Integer findCount(RuleBean ruleBean);

	List<Rule> findPage(RuleBean ruleBean);

	List<Rule> findAll();

	Rule findById(String id);

	Rule findByCode(@Param("code") String code);

	int deleteById(String id);

	int save(Rule rule);

	int update(Rule rule);
}
