package com.mry.service.attendance;

import com.mry.entity.dao.attendance.AttendanceDao;
import com.mry.entity.store.attendance.Attendance;
import com.mry.entity.user.LeaveApplication;
import com.mry.entity.user.Staff;
import com.mry.enums.AttendanceEnum;
import com.mry.enums.WorkEnum;
import com.mry.service.BaseService;
import com.mry.service.store.StaffService;
import com.mry.util.DatetimeUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.PageOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * Created by somedragon on 2018/4/26.
 */
@Service
@Transactional
public class AttendanceService extends BaseService{

    private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);

    @Resource
    private AttendanceDao attendanceDao;

    @Resource
    private StaffService staffService;

    public List<Attendance> findByUserIdAndTime(Long userId, Date sdate, Date edate) {
        return attendanceDao.findByUserIdAndDate(userId, sdate, edate);
    }
    public void editAttendance(Long userId, Integer type, String date){
        Staff staff = staffService.getId(userId);
        Long storeId = staff.getStoreId();
        Date current = new Date();
        String d = DatetimeUtil.formatDate(current);
        Date currentDate = DatetimeUtil.parseDate(d);

        Attendance attendance = attendanceDao.findByStoreIdAndUserIdAndDate(storeId, userId, currentDate);
        if(attendance==null){
            Attendance at = new Attendance();
            at.setCreateDate(currentDate);
            at.setUserId(userId);
            at.setRId(storeId);
            at.setCurrentDate(currentDate);
            attendanceDao.save(at);
            attendance = attendanceDao.findByStoreIdAndUserIdAndDate(storeId, userId, currentDate);

        }
        if(date!=null){
            current = DatetimeUtil.parseDateHourWithException(date);
        }
        if(type.equals(AttendanceEnum.ON_WORK.getCode())){
            attendance.setStartWork(current);
        }else  if(type.equals(AttendanceEnum.DOWN_WORK.getCode())){
            attendance.setEndWork(current);
        }else if(type.equals(AttendanceEnum.BU_END.getCode())){
            attendance.setEndWork(current);
            attendance.setEndStatus(WorkEnum.FALSE_BU.getCode());
        } else if(type.equals(AttendanceEnum.BU_START.getCode())){
            attendance.setStartWork(current);
            attendance.setStartStatus(WorkEnum.TRUE_BU.getCode());
        }
        attendanceDao.update(attendance);
    }

    public Attendance findByStoreIdAndUserAndTime(Long storeId, Long userId, Date current){
        return attendanceDao.findByStoreIdAndUserIdAndDate(storeId, userId, current);
    }


    @Resource
    private LeaveApplicationService leaveApplicationService;




    public void addLeaveApplication(Long storeId, Long userId, Integer type, String start, String end){
           Date current = new Date();
           String d = DatetimeUtil.formatDate(current);
           Date currentDate = DatetimeUtil.parseDate(d);

           Date sDate = DatetimeUtil.parseDateHourWithException(start);
           Date eDate = DatetimeUtil.parseDateHourWithException(end);
           int days = (int) ((eDate.getTime() - sDate.getTime()) / (1000 * 3600 * 24));
           LeaveApplication l = new LeaveApplication();
           l.setStartDate(sDate);
           l.setEndDate(eDate);
           l.setNum(days);
           l.setStaffId(userId);
           l.setType(type);
           l.setStoreId(storeId);
           leaveApplicationService.save(l);
           Calendar scalendar = Calendar.getInstance();
           scalendar.setTime(sDate);
           Calendar ecalendar = Calendar.getInstance();
           ecalendar.setTime(eDate);
           for (int i = 0; i < days; i++) {
               scalendar.add(Calendar.DATE, i);
               String date = DatetimeUtil.formatDate(scalendar.getTime());
               Date c = DatetimeUtil.parseDate(date);
               Attendance a = new Attendance();
               a.setUserId(userId);
               a.setCreateDate(currentDate);
               a.setCreateDate(c);
               a.setSign(type);
               a.setRId(storeId);
               attendanceDao.save(a);
           }

    }



}
