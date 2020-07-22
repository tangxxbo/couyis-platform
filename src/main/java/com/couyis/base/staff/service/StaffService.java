package com.couyis.base.staff.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.base.staff.IStaffService;
import com.couyis.base.staff.bean.StaffBean;
import com.couyis.base.staff.dao.StaffMapper;
import com.couyis.base.staff.enums.StaffStatus;
import com.couyis.base.staff.pojo.Staff;
import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.account.IAccountService;
import com.couyis.frame.account.enums.AccountCategory;

@Service
public class StaffService implements IStaffService {
	@Resource
	private StaffMapper staffMapper;
	@Resource
	private IAccountService accountService;

	@Transactional
	public void save(Staff staff) {
		// TODO Auto-generated method stub
		staff.setId(UUIDUtil.get());
		staff.getAccount().setCategory(AccountCategory.COMMON);
		accountService.save(staff.getAccount());
		staff.setAccountId(staff.getAccount().getId());
		staff.setStatus(StaffStatus.NORMAL);
		staffMapper.save(staff);
	}

	@Transactional
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		accountService.update(staff.getAccount());

		staffMapper.update(staff);
	}
	
	@Transactional
	public void dimission(String id,String updateUser,Date updateTime) {
		// TODO Auto-generated method stub
		Staff staff = new Staff();
		staff.setId(id);
		staff.setUpdateUser(updateUser);
		staff.setUpdateTime(updateTime);
		staff.setStatus(StaffStatus.QUIT);
		staffMapper.update(staff);
	}

	public Staff findById(String id) {
		// TODO Auto-generated method stub
		Staff staff = staffMapper.findById(id);
		staff.setAccount(accountService.findById(staff.getAccountId()));
		return staff;
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		staffMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(staffMapper.findCount((StaffBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(staffMapper.findPage((StaffBean) pageBean));
		return pageBean;
	}

	public Staff findByCode(String code) {
		// TODO Auto-generated method stub
		return staffMapper.findByCode(code);
	}

	public List<String> findByOrgPosition(String orgId, String positionId) {
		// TODO Auto-generated method stub
		return staffMapper.findByOrgPosition(orgId, positionId);
	}

	@Override
	public List<Staff> findSearch(String name) {
		// TODO Auto-generated method stub
		return staffMapper.findSearch(name);
	}

}
