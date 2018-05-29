package com.mry.task;

import com.mry.entity.store.attendance.Attendance;
import com.mry.entity.user.Staff;
import com.mry.service.BaseService;
import com.mry.service.attendance.AttendanceService;
import com.mry.service.attendance.BusinessDateService;
import com.mry.service.store.StaffService;
import com.mry.util.DatetimeUtil;
import org.apache.cxf.message.Attachment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by somedragon on 2018/5/18.
 */
@Service
public class TaskAttendance extends BaseService {

    @Resource
    private AttendanceService attendanceService;
    @Resource
    private BusinessDateService businessDateService;
    @Resource
    private StaffService staffService;

    /**
     * 定时器 每玩12点判断，签到表中是否有人旷工， 有责添加旷工记录
     */
    public void addAttendance(){
        Date current = new Date();
        String d = DatetimeUtil.formatDate(current);
        Date currentDate = DatetimeUtil.parseDate(d);
        //如果上班时间有个日期 先暂定storeId 为12
        Long storeId = 12L;
        if(businessDateService.findByDate(currentDate)){
            List<Staff>  list = staffService.findStoreId(storeId);
            for (Staff s:list){
                //为空说明员工未上班
                if (attendanceService.findByStoreIdAndUserAndTime(storeId, s.getId(), current)==null){
                    Attendance attendance = new Attendance();
                    //旷工
                    attendance.setSign(5);
                    attendance.setUserId(s.getId());
                    attendance.setCurrentDate(currentDate);
                    attendance.setCurrentDate(currentDate);
                    attendance.setRId(s.getStoreId());
                    attendanceService.save(attendance);
                }
            }
        };
    }
}
