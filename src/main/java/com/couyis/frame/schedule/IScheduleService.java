package com.couyis.frame.schedule;

import java.util.List;

import com.couyis.common.web.IService;
import com.couyis.frame.schedule.enums.ScheduleStatus;
import com.couyis.frame.schedule.pojo.Schedule;

public interface IScheduleService extends IService<Schedule> {
	public List<Schedule> findByStatus(ScheduleStatus status);
}
