package com.mry.service.store;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ComplaintsDao;
import com.mry.entity.dao.store.CustomerDao;
import com.mry.entity.dao.store.ServiceOrdersDao;
import com.mry.entity.dao.store.StaffDao;
import com.mry.entity.store.ComplaintsManagement;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.user.Customer;
import com.mry.entity.user.Staff;
import com.mry.json.ResultsWrapper;
import com.mry.json.store.ComplaintsJson;
import com.mry.json.store.ComplaintsListJson;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/11/3.
 */
@Service
@Transactional
public class ComplaintsService extends BaseService {

    @Resource
    public ComplaintsDao complaintsDao;
    @Resource
    public StoreDao storeDao;

    @Resource
    public CustomerDao customerDao;
    @Resource
    public ServiceOrdersDao serviceOrdersDao;

    @Resource
    public StaffDao staffDao;

    public int save(String authToken, ComplaintsJson data) {

        Staff user = getStaffByAuthToken(authToken);
        Customer cus = customerDao.findById(data.getCustomerId());
        ServiceOrders order = serviceOrdersDao.findById(data.getServiceId());
        Staff bts = staffDao.findById(data.getBtsrId());
        ComplaintsManagement c = new ComplaintsManagement();
        c.setStoreId(user.getStoreId());
        c.setStoreName(user.getStoreName());
        c.setCustomerId(data.getCustomerId());
        c.setCustomerName(cus.getRealName());
        //投诉编号
        c.setTsStatus("1");
        c.setCode(getTsCode(user.getStoreId()));
        c.setBtsrId(data.getBtsrId());
        c.setBtsrName(bts.getRealName());
        c.setComplaintsCode(bts.getCode());
        c.setComplaintsTime(DatetimeUtil.formatDate(new Date()));
        c.setComplaintsReason(data.getComplaintsReason());
        c.setServiceId(data.getServiceId());
        c.setServiceCode(order.getServiceOrderNumber());
        c.setEnable(true);
        complaintsDao.saveObject(c);
        return 1;

    }

    public int edit(String authToken, ComplaintsJson data) {
        Staff user = getStaffByAuthToken(authToken);
        ComplaintsManagement c =complaintsDao.findById(data.getId());
        Customer cus = customerDao.findById(data.getCustomerId());
        ServiceOrders order = serviceOrdersDao.findById(data.getServiceId());
        Staff bts = staffDao.findById(data.getBtsrId());

        c.setCustomerId(data.getCustomerId());
        c.setCustomerName(cus.getRealName());
        //投诉编号
        c.setTsStatus("1");
        c.setCode(getTsCode(user.getStoreId()));
        c.setBtsrId(data.getBtsrId());
        c.setBtsrName(bts.getRealName());
        c.setComplaintsCode(bts.getCode());
        c.setComplaintsTime(DatetimeUtil.formatDate(new Date()));
        c.setComplaintsReason(data.getComplaintsReason());
        c.setServiceId(data.getServiceId());
        c.setServiceCode(order.getServiceOrderNumber());
        c.setEnable(true);
        complaintsDao.saveObject(c);
        return 1;
    }

    public ResultsWrapper<ComplaintsListJson> findComplaintsList(String authToken, String name, Integer page, Integer pageSize) {
        Staff user = getStaffByAuthToken(authToken);
        List<ComplaintsManagement> users = complaintsDao.findList(user.getStoreId(),name,page,pageSize);
        List<ComplaintsListJson> json = new ArrayList<ComplaintsListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new ComplaintsListJson(a)));
        }
        Long count = complaintsDao.findListCount(user.getStoreId(),name);

        ResultsWrapper<ComplaintsListJson> h = new ResultsWrapper<ComplaintsListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public ComplaintsListJson findById(Long id) {
        ComplaintsManagement c =complaintsDao.findById(id);
        ComplaintsListJson json = new ComplaintsListJson(c);
        return json;
    }

    public int delete(String authToken, Long id) {
        return complaintsDao.delete(id);
    }

    /**
     * 投诉编码生成
     * @return
     */
    public String getTsCode(Long id){
        StoreManagement store = storeDao.findById(id);
        String code ="0000";
        Long count = complaintsDao.findMax(id);
        if(count>=0 && count <= 9){
            code ="ts"+store.getCode()+"000"+count;
        }else  if(count>=10 && count <=99){
            code = "ts"+store.getCode()+"00"+count;
        }else  if(count>=100 && count <=999){
            code = "ts"+store.getCode()+"0"+count;
        }else {
            code = "ts"+store.getCode()+""+count;
        }
        return code;
    }

    public int handle(String authToken, ComplaintsJson data) {

        Staff user = getStaffByAuthToken(authToken);
        ComplaintsManagement c =complaintsDao.findById(data.getId());

        c.setHandlePerson(user.getRealName());
        c.setPersonId(user.getId());
        c.setTreatmentMethods(data.getTreatmentMethods());
        c.setProcessingTime(DatetimeUtil.formatDate(new Date()));
        c.setTsStatus("2");
        complaintsDao.updateObject(c);
        return 1;

    }
}
