package com.couyis.frame.account.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;
import com.couyis.frame.account.IAccountService;
import com.couyis.frame.account.bean.AccountBean;
import com.couyis.frame.account.pojo.Account;

@RestController
@RequestMapping("/frame/account")
public class AccountController extends BaseController {
	@Resource
	private IAccountService accountService;

	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody AccountBean pageBean) {
		return accountService.findPage(pageBean);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Account account) {
		accountService.save(account);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestBody Account account) {
		accountService.update(account);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		accountService.delete(id);
	}

	@RequestMapping(value = "/edit/{id}")
	public Account findById(@PathVariable("id") String id) {
		return accountService.findById(id);
	}

	@RequestMapping(value = "/checkAccount")
	public Boolean checkAccount(@RequestBody(required = false) String account) {
		return accountService.checkAccount(account);
	}

	@RequestMapping(value = "/findByAccount")
	public Account findByAccount(@RequestBody(required = false) String account) {
		return accountService.findByAccount(account);
	}

	@RequestMapping(value = "/restPassword")
	public void restPassword(@RequestBody() Account account) {
		Account temp = accountService.findByAccount(account.getAccount());
		temp.setPassword(account.getPassword());
		accountService.chanagePassword(temp);
	}

//	@RequestMapping(value = "/findFeature")
//	public List<ItemBean> findFeature(@RequestBody(required = false) String account) {
//		return accountService.findFeature(account);
//	}
//
//	@RequestMapping(value = "/findRole")
//	public List<CheckBoxBean> findRole(@RequestBody(required = false) String account) {
//		return accountService.findRole(account);
//	}
}
