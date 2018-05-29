package com.mry.service.attendance;

import com.mry.entity.dao.attendance.LeaveApplicationDao;
import com.mry.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by somedragon on 2018/5/18.
 */
@Service
@Transactional
public class LeaveApplicationService extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(LeaveApplicationService.class);

    @Resource
    private LeaveApplicationDao leaveApplicationDao;


}
