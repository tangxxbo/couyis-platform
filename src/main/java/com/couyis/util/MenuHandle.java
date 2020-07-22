package com.couyis.util;

import java.util.ArrayList;
import java.util.List;

import com.couyis.frame.account.bean.AccountMenuBean;

public class MenuHandle {
	/**
	 * 将菜单数据树形结构数据
	 * 
	 * @param accountMenuBeans 菜单数据
	 * @return
	 */
	public static List<AccountMenuBean> getMenu(List<AccountMenuBean> accountMenuBeans) {
		List<AccountMenuBean> ambs = comboTree(accountMenuBeans, null);
		return ambs;
	}

	private static List<AccountMenuBean> comboTree(List<AccountMenuBean> accountMenuBeans, String parentId) {
		List<AccountMenuBean> temp = findByParentId(accountMenuBeans, parentId);
		if (temp.size() <= 0) {
			return temp;
		}
		for (AccountMenuBean accountMenuBean : temp) {
			accountMenuBean.setAccountMenuBeans(comboTree(accountMenuBeans, accountMenuBean.getMenuId()));
		}
		return temp;
	}

	private static List<AccountMenuBean> findByParentId(List<AccountMenuBean> accountMenuBeans, String parentId) {
		List<AccountMenuBean> temp = new ArrayList<AccountMenuBean>();
		for (AccountMenuBean accountMenuBean : accountMenuBeans) {
			if (parentId == null) {
				if (accountMenuBean.getParentId() == null) {
					temp.add(accountMenuBean);
				}
			} else {
				if (parentId.equals(accountMenuBean.getParentId())) {
					temp.add(accountMenuBean);
				}
			}
		}
		return temp;
	}
}
