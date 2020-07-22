package com.couyis.frame.log.dao;

import java.util.List;

import com.couyis.frame.log.bean.AccessLogBean;
import com.couyis.frame.log.pojo.AccessLog;

/**
 * 系统访问资源表数据库操作
 * 
 * @author 邓放平
 *
 */
public interface AccessLogMapper {

	Integer findCount(AccessLogBean accessLogBean);

	List<AccessLog> findPage(AccessLogBean accessLogBean);

	AccessLog findById(String id);

	int deleteById(String id);

	int save(AccessLog accessLog);

}