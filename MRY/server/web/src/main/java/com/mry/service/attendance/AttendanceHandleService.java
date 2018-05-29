package com.mry.service.attendance;

import com.mry.entity.dao.attendance.AttendanceHandleDao;
import com.mry.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by somedragon on 2018/4/26.
 */
@Service
@Transactional
public class AttendanceHandleService extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceHandleService.class);

    @Resource
    private AttendanceHandleDao attendanceHandleDao;
}
