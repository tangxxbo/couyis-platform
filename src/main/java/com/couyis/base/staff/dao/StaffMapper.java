package com.couyis.base.staff.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.base.staff.bean.StaffBean;
import com.couyis.base.staff.pojo.Staff;

public interface StaffMapper {
	Integer findCount(StaffBean staffBean);

	List<Staff> findPage(StaffBean staffBean);

	List<Staff> findAll();

	Staff findById(String id);

	Staff findByCode(String code);

	int deleteById(String id);

	int save(Staff staff);

	int update(Staff staff);

	List<String> findByOrgPosition(@Param("orgId") String orgId, @Param("positionId") String positionId);

	public List<Staff> findSearch(@Param("name") String name);
}
