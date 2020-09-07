package com.couyis.frame.account.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.frame.account.pojo.Account;
/**
  * 关于RestFul风格的接口写法
 * 
 * @author 唐晓旭
 * */
@RestController
@RequestMapping("/Swagg")
public class AccountSwaController {
	// 创建线程安全的Map 
    static Map<Long, Account> account = Collections.synchronizedMap(new HashMap<Long, Account>()); 
 
    @RequestMapping(value="/", method=RequestMethod.GET) 
    public List<Account> getAccountList() { 
        // 处理"/users/"的GET请求，用来获取用户列表 
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递 
        List<Account> r = new ArrayList<Account>(account.values()); 
        return r; 
    } 
 
    @RequestMapping(value="/", method=RequestMethod.POST) 
    public String postAccount(@ModelAttribute Account acco) { 
        // 处理"/users/"的POST请求，用来创建User 
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数 
    	account.put(Long.parseLong(acco.getId()), acco); 
        return "success"; 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.GET) 
    public Account getAccount(@PathVariable Long id) { 
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息 
        // url中的id可通过@PathVariable绑定到函数的参数中 
        return account.get(id); 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
    public String putAccount(@PathVariable Long id, @ModelAttribute Account acco) { 
        // 处理"/users/{id}"的PUT请求，用来更新User信息 
    	Account u = account.get(id); 
        u.setAccount(acco.getAccount()); 
        u.setPassword(acco.getPassword()); 
        account.put(id, u); 
        return "success"; 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
    public String deleteAccount(@PathVariable Long id) { 
        // 处理"/users/{id}"的DELETE请求，用来删除User 
    	account.remove(id); 
        return "success"; 
    }
}
