package com.mry.service.store;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.*;
import com.mry.entity.dao.system.ProductDao;
import com.mry.entity.store.RoomManagement;
import com.mry.entity.store.card.Bill;
import com.mry.entity.store.customer.MyProduct;
import com.mry.entity.store.customer.MyProject;
import com.mry.entity.store.project.ProductManagement;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;
import com.mry.entity.user.Customer;
import com.mry.entity.user.Staff;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.*;
import com.mry.json.store.serviceOrder.ServiceOrderJson;
import com.mry.json.store.serviceOrder.ServiceOrderListJson;
import com.mry.json.store.serviceOrder.ServiceProductJson;
import com.mry.json.store.serviceOrder.ServiceProjectJson;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/11/14.
 * 服务单
 */
@Service
@Transactional
public class ServiceOrdersService extends BaseService {

    @Resource
    public ServiceOrdersDao serviceOrdersDao;

    @Resource
    public StoreDao storeDao;

    @Resource
    public CustomerDao customerDao;

    @Resource
    private ProductDao productDao;

    @Resource
    private ProjectDao projectDao;

    @Resource
    public StaffDao staffDao;

    @Resource
    public RoomDao roomDao;


    /**
     * 创建服务单
     * @param authToken
     * @param data
     * @return
     */
    public int save(String authToken, ServiceOrderJson data) {

        Staff user = getStaffByAuthToken(authToken);
        Customer cus = customerDao.findById(data.getCustomerId());
        Staff op = staffDao.findById(data.getOperatorId());
        RoomManagement r = roomDao.findById(data.getRoomId());
        r.setRoomStatus("1");
        roomDao.update(r);
        ServiceOrders s = new ServiceOrders();
        s.setStoreId(user.getStoreId());
        s.setStoreName(user.getStoreName());
        s.setCustomerId(data.getCustomerId());
        s.setCustomer(cus.getRealName());
        s.setLevel(cus.getLevel());
        s.setPhoneNumber(cus.getPhoneNumber());
        s.setServiceOrderNumber(getServiceOrderNumber(authToken));
        if(null == data.getServiceType()){
            s.setServiceType("2");
        }else {
            s.setServiceType(data.getServiceType());
        }

        s.setCreateTime(new Date());
        s.setOperatorId(data.getOperatorId());
        s.setOperatorName(op.getRealName());
        s.setAppoint(data.getAppoint());
        s.setServiceRoom(r.getRoomName());
        s.setRoomId(data.getRoomId());
        s.setPreId(data.getPreId());
        s.setPreSale(data.getPreSale());
        s.setServicStatus("0");
        s.setOrderType(data.getOrderType());
        s.setAnonymous(data.getAnonymous());
        s.setEnable(true);
        Double total=0.00;
        Double kkou=0.00;
        Double zf=0.00;
        List<MyProject> jects = customerDao.findMyProject(data.getCustomerId());
        List<MyProduct> ducts = customerDao.findMyProduct(data.getCustomerId());
        if(data.getOrderType().equals("2")){
            if (data.getProject() != null) {
                List<ServiceProject> list = new ArrayList<>();
                for (ServiceProjectJson item : data.getProject()) {
                    ProjectManagement pj = projectDao.findById(item.getProjectId());
                    if(jects.size()>0) {
                        Integer tage = 0;
                        for (MyProject j : jects) {
                            if (item.getProjectId().equals(j.getProjectId())) {
                                tage=1;
                                ServiceProject temp = item.convert();
                              //  total = total + pj.getMoney().doubleValue();
                            //    kkou = kkou + pj.getMoney().doubleValue();
                                temp.setOrder(s);
                                temp.setCardId(j.getCard().getCardId());
                                temp.setCardName(j.getCard().getCardName());
                                temp.setMoney(pj.getBuckleMoney());
                                temp.setProjectName(pj.getProjectName());
                                list.add(temp);
                                break;
                            }
                        }
                        if(tage==0){
                            ServiceProject temp = item.convert();
                            //          total = total + pj.getMoney().doubleValue();
                            zf = zf + pj.getBuckleMoney().doubleValue();
                            temp.setMoney(pj.getBuckleMoney());
                            temp.setProjectName(pj.getProjectName());
                            temp.setOrder(s);
                            list.add(temp);
                        }
                    }else{
                        ServiceProject temp = item.convert();
                     //   total = total + pj.getMoney().doubleValue();
                        zf = zf + pj.getBuckleMoney().doubleValue();
                        temp.setMoney(pj.getBuckleMoney());
                        temp.setProjectName(pj.getProjectName());
                        temp.setOrder(s);
                        list.add(temp);
                    }

                }
                s.setProject(list);
            }
            if (data.getProduct() != null) {
                List<ServiceProduct> list = new ArrayList<>();
                for (ServiceProductJson item : data.getProduct()) {
                    ProductManagement pm = productDao.findById(item.getProductId());
                    if(ducts.size()>0) {
                        Integer tage = 0;
                        for (MyProduct d : ducts) {
                            if (item.getProductId().equals(d.getProductId())) {
                                tage = 1;
                                ServiceProduct temp = item.convert();
                            //    total = total + pm.getMoney().doubleValue();
                            //    kkou = kkou + pm.getCashMoney().doubleValue();
                             //   temp.setMoney(pm.getMoney());
                                temp.setProductName(pm.getProductName());
                                temp.setOrder(s);
                                temp.setCardId(d.getCard().getCardId());
                                temp.setCardName(d.getCard().getCardName());
                                list.add(temp);
                            }
                        }
                        if(tage==0){
                            ServiceProduct temp = item.convert();
                            //   total = total + pm.getMoney().doubleValue();
                            zf = zf + pm.getBuckleMoney().doubleValue();
                            temp.setMoney(pm.getBuckleMoney());
                            temp.setProductName(pm.getProductName());
                            temp.setOrder(s);
                            list.add(temp);
                        }
                    }else {
                        ServiceProduct temp = item.convert();
                     //   total = total + pm.getMoney().doubleValue();
                        zf = zf + pm.getCashMoney().doubleValue();
                        temp.setMoney(pm.getCashMoney());
                        temp.setProductName(pm.getProductName());
                        temp.setOrder(s);
                        list.add(temp);
                    }

                }
                s.setProduct(list);

            }
        }else {
            if (data.getProject() != null) {
                List<ServiceProject> list = new ArrayList<>();
                for (ServiceProjectJson item : data.getProject()) {
                    ProjectManagement pj = projectDao.findById(item.getProjectId());
                    ServiceProject temp = item.convert();
                  //  total = total +  pj.getCashMoney().doubleValue();
                    zf = zf+ pj.getCashMoney().doubleValue();
                    temp.setMoney(pj.getCashMoney());
                    temp.setProjectName(pj.getProjectName());
                    temp.setOrder(s);
                    list.add(temp);
                }
                s.setProject(list);
            }

            if (data.getProduct() != null) {
                List<ServiceProduct> list = new ArrayList<>();
                for (ServiceProductJson item : data.getProduct()) {
                    ProductManagement pm = productDao.findById(item.getProductId());
                    ServiceProduct temp = item.convert();
                //    total = total +pm.getMoney().doubleValue();
                    zf = zf+pm.getCashMoney().doubleValue();
                    temp.setMoney(pm.getCashMoney());
                    temp.setProductName(pm.getProductName());
                    temp.setOrder(s);
                    list.add(temp);
                }
                s.setProduct(list);
            }
        }
        s.setTotalAmount(new BigDecimal(total));
        s.setSavingsAmount(new BigDecimal(kkou));
        s.setCashAmount(new BigDecimal(zf));
        serviceOrdersDao.saveObject(s);
        return 1;


    }


    //服务单号=门店编码+时间毫秒+随机4位数
    public String getServiceOrderNumber(String authToken){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time =  formatter.format(new Date());

        Staff user = getStaffByAuthToken(authToken);
        StoreManagement store = storeDao.findById(user.getStoreId());
      //  Long num = serviceOrdersDao.findCount(user.getStoreId());
        String order =store.getCode();

        order =order+time+(Math.random()*9+1)*1000;
//        if(num>=0 && num <= 9){
//            order ="000"+num;
//        }else  if(num>=10 && num <=99){
//            order = "00"+num;
//        }else  if(num>=100 && num <=999){
//            order = "0"+num;
//        }else {
//            order = ""+num;
//        }
        return order;
    }

    public int edit(String authToken, ServiceOrderJson data) {

        Staff user = getStaffByAuthToken(authToken);
        ServiceOrders s = serviceOrdersDao.findById(data.getId());
        Customer cus = customerDao.findById(data.getCustomerId());
        Staff op = staffDao.findById(data.getOperatorId());
        if(s.getRoomId()!=null){
            RoomManagement r = roomDao.findById(s.getRoomId());
            r.setRoomStatus("0");
            roomDao.update(r);
        }
        RoomManagement r = roomDao.findById(data.getRoomId());
        r.setRoomStatus("1");
        roomDao.update(r);
        s.setCustomerId(data.getCustomerId());
        s.setCustomer(cus.getRealName());
        s.setLevel(cus.getLevel());
        s.setPhoneNumber(cus.getPhoneNumber());
        if(null == data.getServiceType()){
            s.setServiceType("2");
        }else {
            s.setServiceType(data.getServiceType());
        }
        s.setCreateTime(new Date());
        s.setOperatorId(data.getOperatorId());
        s.setOperatorName(op.getRealName());
        s.setAppoint(data.getAppoint());
        s.setServiceRoom(r.getRoomName());
        s.setRoomId(data.getRoomId());
    //    s.setPreId(data.getPreId());
        s.setPreSale(data.getPreSale());
        s.setServicStatus("0");
        s.setOrderType(data.getOrderType());
        s.setAnonymous(data.getAnonymous());
        s.setEnable(true);
        serviceOrdersDao.deleteproject(data.getId());
        serviceOrdersDao.deleteproduct(data.getId());
        Double total=0.00;
        Double kkou=0.00;
        Double zf=0.00;
        List<MyProject> jects = customerDao.findMyProject(data.getCustomerId());
        List<MyProduct> ducts = customerDao.findMyProduct(data.getCustomerId());
        if(data.getOrderType().equals("2")){
            if (data.getProject() != null) {
                List<ServiceProject> list = new ArrayList<>();
                for (ServiceProjectJson item : data.getProject()) {
                    ProjectManagement pj = projectDao.findById(item.getProjectId());
                    if(jects.size()>0) {
                        Integer tage = 0;
                        for (MyProject j : jects) {
                            if (item.getProjectId().equals(j.getProjectId())) {
                                tage = 1;
                                ServiceProject temp = item.convert();

                                //  total = total + pj.getMoney().doubleValue();
                                //    kkou = kkou + pj.getMoney().doubleValue();
                                temp.setOrder(s);
                                temp.setCardId(j.getCard().getCardId());
                                temp.setCardName(j.getCard().getCardName());
                                temp.setMoney(pj.getCourseMoney());
                                temp.setProjectName(pj.getProjectName());
                                list.add(temp);
                            }
                        }
                        if(tage==0){
                            ServiceProject temp = item.convert();
                            //          total = total + pj.getMoney().doubleValue();
                            zf = zf + pj.getBuckleMoney().doubleValue();
                            temp.setMoney(pj.getBuckleMoney());
                            temp.setProjectName(pj.getProjectName());
                            temp.setOrder(s);
                            list.add(temp);
                        }
                    }else{
                        ServiceProject temp = item.convert();
                        //   total = total + pj.getMoney().doubleValue();
                        zf = zf + pj.getBuckleMoney().doubleValue();
                        temp.setMoney(pj.getBuckleMoney());
                        temp.setProjectName(pj.getProjectName());
                        temp.setOrder(s);
                        list.add(temp);
                    }

                }
                s.setProject(list);

            }
            if (data.getProduct() != null) {
                List<ServiceProduct> list = new ArrayList<>();
                for (ServiceProductJson item : data.getProduct()) {
                    ProductManagement pm = productDao.findById(item.getProductId());
                    if(ducts.size()>0) {
                        Integer tage = 0;
                        for (MyProduct d : ducts) {

                            if (item.getProductId() == d.getProductId()) {
                                ServiceProduct temp = item.convert();
                                tage = 1;
//                                total = total + pm.getMoney().doubleValue();
//                                kkou = kkou + pm.getMoney().doubleValue();
//                                temp.setMoney(pm.getMoney());
                                temp.setMoney(pm.getCourseMoney());
                                temp.setProductName(pm.getProductName());
                                temp.setOrder(s);
                                temp.setCardId(d.getCard().getCardId());
                                temp.setCardName(d.getCard().getCardName());
                                list.add(temp);
                            }
                        }
                        if(tage==0){
                            ServiceProduct temp = item.convert();
                            //    total = total + pm.getBuckleMoney().doubleValue();
                            zf = zf + pm.getBuckleMoney().doubleValue();
                            temp.setMoney(pm.getBuckleMoney());
                            temp.setProductName(pm.getProductName());
                            temp.setOrder(s);
                            list.add(temp);
                        }
                    }else {
                        ServiceProduct temp = item.convert();
                     //   total = total + pm.getBuckleMoney().doubleValue();
                        zf = zf + pm.getBuckleMoney().doubleValue();
                        temp.setMoney(pm.getBuckleMoney());
                        temp.setProductName(pm.getProductName());
                        temp.setOrder(s);
                        list.add(temp);
                    }

                }
                s.setProduct(list);

            }
        }else {
            if (data.getProject() != null) {
                List<ServiceProject> list = new ArrayList<>();
                for (ServiceProjectJson item : data.getProject()) {
                    ProjectManagement pj = projectDao.findById(item.getProjectId());
                    ServiceProject temp = item.convert();
                    //  total = total +  pj.getCashMoney().doubleValue();
                    zf = zf+ pj.getCashMoney().doubleValue();
                    temp.setMoney(pj.getCashMoney());
                    temp.setProjectName(pj.getProjectName());
                    temp.setOrder(s);
                    list.add(temp);
                }
                s.setProject(list);
            }

            if (data.getProduct() != null) {
                List<ServiceProduct> list = new ArrayList<>();
                for (ServiceProductJson item : data.getProduct()) {
                    ProductManagement pm = productDao.findById(item.getProductId());
                    ServiceProduct temp = item.convert();
              //      total = total +pm.getCashMoney().doubleValue();
                    zf = zf+pm.getCashMoney().doubleValue();
                    temp.setMoney(pm.getCashMoney());
                    temp.setProductName(pm.getProductName());
                    temp.setOrder(s);
                    list.add(temp);
                }
                s.setProduct(list);
            }
        }
        s.setTotalAmount(new BigDecimal(total));
        s.setSavingsAmount(new BigDecimal(kkou));
        s.setCashAmount(new BigDecimal(zf));
        serviceOrdersDao.updateObject(s);
        return 1;
    }

    public ResultsWrapper<ServiceOrderListJson> findServiceOrder(String authToken, String orderType, String name, Integer page, Integer pageSize) {

        Staff user = getStaffByAuthToken(authToken);
        List<ServiceOrders> users = serviceOrdersDao.findServiceOrder(user.getStoreId(),orderType,name,page,pageSize);
        List<ServiceOrderListJson> json = new ArrayList<ServiceOrderListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new ServiceOrderListJson(a)));
        }
        Long count = serviceOrdersDao.findListCount(user.getStoreId(),orderType,name);

        ResultsWrapper<ServiceOrderListJson> h = new ResultsWrapper<ServiceOrderListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public StatusJson settlement(String authToken, Long id) {
        Staff user = getStaffByAuthToken(authToken);
        ServiceOrders s = serviceOrdersDao.findById(id);
        List<MyProject> jects = customerDao.findMyProject(s.getCustomerId());
        StatusJson status = new StatusJson();
        //现金
        Bill bill = new Bill();
        if(s.getOrderType().equals("1")){

            bill.setCustomer(s.getCustomer());
            bill.setCustomerId(s.getCustomerId());
            bill.setMoney(s.getCashAmount());
            bill.setStoreName(user.getStoreName());
            bill.setStoreId(user.getStoreId());
            bill.setServiceId(s.getId());
            bill.setServiceOrderNumber(s.getServiceOrderNumber());
            bill.setBillType(s.getServiceType());
            bill.setPaymentMethod(s.getOrderType());
            bill.setBillTime(new Date());
            bill.setZfmoney(s.getCashAmount());
            bill.setEnable(true);
            status.setStatus(1);
            status.setMessage("支付成功");

            //服务单
        }else if(s.getOrderType().equals("2")){
            Customer cus = customerDao.findById(s.getCustomerId());
        //    BigDecimal payMoney = new BigDecimal(data.getCashAmount());
            if(cus.getMoney().compareTo(s.getCashAmount())==-1){
                status.setStatus(2);
                status.setMessage("余额不足");
                return status;
            }else {
                //减去储蓄卡中的钱
                cus.setMoney(cus.getMoney().subtract(s.getCashAmount()));
                customerDao.updateObject(cus);

                bill.setCustomer(s.getCustomer());
                bill.setCustomerId(s.getCustomerId());

                bill.setStoreName(user.getStoreName());
                bill.setStoreId(user.getStoreId());
                bill.setServiceId(s.getId());
                bill.setServiceOrderNumber(s.getServiceOrderNumber());
                bill.setBillType(s.getServiceType());
                bill.setPaymentMethod(s.getOrderType());
                bill.setBillTime(new Date());
            //    bill.setZfmoney(payMoney);
                bill.setMoney(s.getCashAmount());
                bill.setKkmoney(s.getCashAmount());
                bill.setEnable(true);
                status.setStatus(1);
                status.setMessage("支付成功");
                if(jects.size() > 0){
                    if(s.getProject() != null){
                        for (ServiceProject item : s.getProject()) {
                            for (MyProject j : jects) {
                                if (j.getProjectId() .equals(item.getProjectId()) ){
                                    if(j.getRemaining()>0) {
                                        j.setRemaining(j.getRemaining()-1);
                                        serviceOrdersDao.updateObject(j);
                                    }else{
                                        status.setStatus(3);
                                        status.setMessage("卡扣项目已用完");
                                        return status;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        serviceOrdersDao.saveObject(bill);
        s.setServicStatus("2");
        serviceOrdersDao.updateObject(s);
        return status;

    }

    public ServiceOrderListJson findById(Long id) {
        ServiceOrders s = serviceOrdersDao.findById(id);
        ServiceOrderListJson json = new ServiceOrderListJson(s);
        return json;
    }

    public List<ServiceOrderListJson> findByCustomerId(Long id) {
        List<ServiceOrders> users = serviceOrdersDao.findByCustomerId(id);
        List<ServiceOrderListJson> json = new ArrayList<ServiceOrderListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new ServiceOrderListJson(a)));
        }
        return json;
    }
    //查询上一次服务的单子
    public ServiceOrders findLastService(Long customerId, Long storeId){
        return serviceOrdersDao.findLastService(customerId, storeId);
    }


    public List<ServiceOrders> findByStoreId(Long storeId, Date begin, Date end){

        return serviceOrdersDao.findByStoreIdAndDate(storeId, begin, end);
    }

    public Long findMaxTime( Long storeId){
        return serviceOrdersDao.findMaxTime( storeId);
    }

    public List<ServiceOrders> findByStaffId(Long id){
        return serviceOrdersDao.findByStaffId(id);
    }
}
