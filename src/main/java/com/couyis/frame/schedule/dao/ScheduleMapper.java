package com.couyis.frame.schedule.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.couyis.frame.schedule.bean.ScheduleBean;
import com.couyis.frame.schedule.enums.ScheduleStatus;
import com.couyis.frame.schedule.pojo.Schedule;

public interface ScheduleMapper {
	Integer findCount(ScheduleBean scheduleBean);

	List<Schedule> findPage(ScheduleBean scheduleBean);

	List<Schedule> findAll();

	List<Schedule> findByStatus(@Param("status") ScheduleStatus status);

	Schedule findById(String id);

	int deleteById(String id);

	int save(Schedule schedule);

	int update(Schedule schedule);
}
