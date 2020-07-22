package com.couyis.base.rule;

import com.couyis.base.rule.pojo.Rule;
import com.couyis.common.web.IService;

public interface IRuleService extends IService<Rule> {
	public String generate(String code);
}
