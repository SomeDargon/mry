package com.mry.service.attendance;

import com.mry.entity.dao.attendance.BusinessDateDao;
import com.mry.entity.store.attendance.BusinessDate;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.json.store.ProjectListJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by somedragon on 2018/5/18.
 */

@Service
@Transactional
public class BusinessDateService extends BaseService {

    @Resource
    private BusinessDateDao businessDateDao;
    public Boolean findByDate(Date date) {
        return businessDateDao.findById(date)==null;
    }

    public List<BusinessDate> getStartAndEndTime(Date sDate, Date eDate){
        return businessDateDao.getStartAndEndTime(sDate, eDate);
    }
}
