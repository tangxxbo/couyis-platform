package com.couyis.frame.index.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.common.util.MD5Util;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.controller.BaseController;
import com.couyis.frame.account.IAccountService;
import com.couyis.frame.account.pojo.Account;
import com.couyis.frame.index.bean.AccountBean;
import com.couyis.frame.index.bean.LoginBean;
import com.couyis.frame.index.bean.LoginResult;
import com.couyis.util.redis.RedisUtil;

@RestController
public class IndexController extends BaseController {
	@Autowired
	private RedisUtil redisUtil;
	@Resource
	private IAccountService accountService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public LoginResult login(@RequestBody(required = false) LoginBean loginBean, HttpServletRequest request) {
		Boolean login = accountService.login(loginBean.getAccount(), loginBean.getPassword());
		List<Object> resources = accountService.findResourceAuthority(loginBean.getAccount());
		List<Object> authoritys = accountService.findDisplayAuthority(loginBean.getAccount());
		Map<String, Object> map = new HashMap<String, Object>();
		if (login) {
			String accessToken = UUIDUtil.get();
			String accountToken = UUIDUtil.get();
			String resourcesToken = UUIDUtil.get();
			String authorityToken = UUIDUtil.get();
			map.put("accountToken", accountToken);
			map.put("resourcesToken", resourcesToken);
			map.put("authorityToken", authorityToken);
			redisUtil.hmset(accessToken, map, 1800);
			redisUtil.set(accountToken, loginBean.getAccount(), 1800);
			redisUtil.lSet(resourcesToken, resources, 1800);
			redisUtil.lSet(authorityToken, authoritys, 1800);
			
			return new LoginResult(true, "用户名密码验证成功！", accessToken,loginBean.getAccount(),authoritys);
		}
		return new LoginResult(false, "用户名密码验证失败！", null,null,null);
	}
	
	@RequestMapping(path = "/logout")
	public void logout(HttpServletRequest request) {
		String accessToken  = getAccessToken(request);
		Map<Object, Object> map = redisUtil.hmget(accessToken);		
		String authorityToken = map.get("authorityToken").toString();
		String resourcesToken = map.get("resourcesToken").toString();
		String accountToken = map.get("accountToken").toString();
		redisUtil.del(accessToken,authorityToken,resourcesToken,accountToken);		
	}

	@RequestMapping(value = "/checkPassword")
	public Boolean checkPassword(@RequestBody Map<String,Object> reqMap, HttpServletRequest request) {
		Account temp = accountService.findByAccount(getAccount(request));
		return temp.getPassword().equals(MD5Util.MD5(reqMap.get("password").toString()));
	}

	@RequestMapping(value = "/changePassword")
	public void changePassword(@RequestBody() Account account, HttpServletRequest request) {
		Account temp = accountService.findByAccount(getAccount(request));
		temp.setPassword(account.getPassword());
		accountService.chanagePassword(temp);
	}
	
	@RequestMapping(path = "/getAcc")
	public AccountBean getAcc(HttpServletRequest request) {
		
		Map<Object, Object> map = redisUtil.hmget(getAccessToken(request));
		
		String authorityToken = map.get("authorityToken").toString();
		
		String accountToken = map.get("accountToken").toString();
		
		String account = redisUtil.get(accountToken).toString();
		
		List<Object> authoritys = redisUtil.lGet(authorityToken, 0, -1);
		
		AccountBean accountBean = new AccountBean();
		accountBean.setAccount(account);
		accountBean.setAuthoritys(authoritys);
		
		return accountBean;
	}

	@RequestMapping(value = "/getToken")
	public String getToken() {
		String token = UUIDUtil.get();
		redisUtil.set(token, token, 1800);
		return token;
	}
}
