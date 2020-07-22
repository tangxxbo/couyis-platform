package com.couyis.base.staff;

import java.util.Date;
import java.util.List;

import com.couyis.base.staff.pojo.Staff;
import com.couyis.common.web.IService;

public interface IStaffService extends IService<Staff> {
	Staff findByCode(String code);
	
	void dimission(String id,String updateUser,Date updateTime);
	
	List<String> findByOrgPosition(String orgId, String positionId);
	
	public List<Staff> findSearch(String name);
}
