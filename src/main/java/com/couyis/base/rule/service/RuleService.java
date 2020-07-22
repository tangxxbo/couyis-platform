package com.couyis.base.rule.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.base.rule.IRuleService;
import com.couyis.base.rule.bean.RuleBean;
import com.couyis.base.rule.dao.RuleMapper;
import com.couyis.base.rule.pojo.Rule;
import com.couyis.common.util.DateUtil;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;

@Service
public class RuleService implements IRuleService {
	@Resource
	private RuleMapper ruleMapper;

	@Transactional
	public void save(Rule rule) {
		// TODO Auto-generated method stub
		rule.setId(UUIDUtil.get());
		rule.setCounts(0);
		rule.setToDay(new Date());
		ruleMapper.save(rule);
	}

	@Transactional
	public void update(Rule rule) {
		// TODO Auto-generated method stub
		ruleMapper.update(rule);
	}

	public Rule findById(String id) {
		// TODO Auto-generated method stub
		return ruleMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		ruleMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(ruleMapper.findCount((RuleBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(ruleMapper.findPage((RuleBean) pageBean));
		return pageBean;
	}

	@Transactional
	public String generate(String code) {
		// TODO Auto-generated method stub
		Rule rule = ruleMapper.findByCode(code);
		Date now = new Date();
		StringBuilder codesb = new StringBuilder();
		if (DateUtil.getDateString(rule.getToDay(), rule.getDateFormat())
				.equals(DateUtil.getDateString(now, rule.getDateFormat()))) {
			// 当前 直接累加
			rule.setCounts(rule.getCounts() + 1);
			codesb.append(rule.getPrefix() == null ? "" : rule.getPrefix());
			codesb.append(DateUtil.getDateString(rule.getToDay(), rule.getDateFormat()));
			codesb.append(String.format("%0" + rule.getNumber() + "d", rule.getCounts()));
		} else {
			rule.setCounts(1);
			rule.setToDay(now);
			codesb.append(rule.getPrefix() == null ? "" : rule.getPrefix());
			codesb.append(DateUtil.getDateString(rule.getToDay(), rule.getDateFormat()));
			codesb.append(String.format("%0" + rule.getNumber() + "d", rule.getCounts()));
		}
		ruleMapper.update(rule);
		return codesb.toString();
	}

}
