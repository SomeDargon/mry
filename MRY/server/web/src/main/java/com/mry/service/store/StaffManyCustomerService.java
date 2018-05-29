package com.mry.service.store;

import com.mchange.v2.beans.BeansUtils;
import com.mry.entity.dao.store.StaffManyCustomerDao;
import com.mry.entity.dto.StaffDTO;
import com.mry.entity.user.Staff;
import com.mry.entity.user.StaffManyCustomer;
import com.mry.form.StaffManyCustomerFrom;
import com.mry.resources.store.StaffManyCustomerResource;
import com.mry.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by somedragon on 2018/4/17.
 */
@Service
@Transactional
public class StaffManyCustomerService  extends BaseService {

    @Resource
    private StaffManyCustomerDao staffManyCustomerDao;
    @Resource
    private StaffService staffService;
    public void save(StaffManyCustomerFrom staffManyCustomerFrom){
        StaffManyCustomer staffManyCustomer = findByCustomer(staffManyCustomerFrom.getCustomerId(), staffManyCustomerFrom.getStoreId(), staffManyCustomerFrom.getType());
        if(staffManyCustomer == null){
            staffManyCustomer = new StaffManyCustomer();
            BeanUtils.copyProperties(staffManyCustomerFrom, staffManyCustomer);
            staffManyCustomerDao.save(staffManyCustomer);
            return;
        }else {
            staffManyCustomer.setStaffId(staffManyCustomerFrom.getStaffId());
            staffManyCustomerDao.update(staffManyCustomer);
        }

    }


    public StaffManyCustomer findByCustomer(Long id, Long stordId, Integer type){
        return staffManyCustomerDao.findCustomer(id, stordId, type);
    }

    public StaffDTO findByStaff(Long id, Long stordId, Integer type){
        StaffManyCustomer s  = findByCustomer(id, stordId, type);
            Staff staff  = staffService.getId(s.getStaffId());
        StaffDTO staffDTO = new StaffDTO();
        BeanUtils.copyProperties(staff, staffDTO);
        return staffDTO;
    }
}
