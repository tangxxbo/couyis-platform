package com.couyis.frame.schedule.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.frame.schedule.IScheduleService;
import com.couyis.frame.schedule.bean.ScheduleBean;
import com.couyis.frame.schedule.dao.ScheduleMapper;
import com.couyis.frame.schedule.enums.ScheduleStatus;
import com.couyis.frame.schedule.pojo.Schedule;

@Service
public class ScheduleService implements IScheduleService {
	@Resource
	private ScheduleMapper scheduleMapper;

	@Transactional
	public void save(Schedule schedule) {
		// TODO Auto-generated method stub
		schedule.setId(UUIDUtil.get());
		scheduleMapper.save(schedule);
	}

	@Transactional
	public void update(Schedule schedule) {
		// TODO Auto-generated method stub
		scheduleMapper.update(schedule);
	}

	public Schedule findById(String id) {
		// TODO Auto-generated method stub
		return scheduleMapper.findById(id);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		scheduleMapper.deleteById(id);
	}

	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(scheduleMapper.findCount((ScheduleBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(scheduleMapper.findPage((ScheduleBean) pageBean));
		return pageBean;
	}

	public List<Schedule> findByStatus(ScheduleStatus status) {
		// TODO Auto-generated method stub
		return scheduleMapper.findByStatus(status);
	}

}
