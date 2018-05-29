package com.mry.service.store;

import com.mry.entity.dao.store.CustomerDao;
import com.mry.entity.dao.store.ServiceOrdersDao;
import com.mry.entity.dao.system.CardDao;
import com.mry.entity.dao.system.ProductCardDao;
import com.mry.entity.store.card.*;
import com.mry.entity.store.customer.*;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.entity.store.project.ProjectProduct;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;
import com.mry.entity.user.Customer;
import com.mry.entity.user.Staff;
import com.mry.entity.vo.CardVO;
import com.mry.enums.ProductEnum;
import com.mry.json.ResultsWrapper;
import com.mry.json.store.*;
import com.mry.json.store.serviceOrder.ServiceCardProjectJson;
import com.mry.json.store.serviceOrder.ServiceProductListJson;
import com.mry.json.store.serviceOrder.ServiceProjectListJson;
import com.mry.service.BaseService;
import com.mry.service.system.*;
import com.mry.util.DatetimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by kaik on 2017/10/31.
 */
@Service
@Transactional
public class CustomerService extends BaseService {

    @Resource
    public CustomerDao customerDao;
    @Resource
    private TreatmentService treatmentService;

    @Resource
    private CardDao cardDao;
    @Resource
    public ServiceOrdersDao serviceOrdersDao;
    @Resource
    private ProductCardDao productCardDao;
    @Resource
    private ExtensionService extensionService;
    @Resource
    private ActivityService activityService;
    public int save(String authToken, CustomerJson data) {
        Staff user = getStaffByAuthToken(authToken);
        Customer cus = new Customer();

        cus.setStoreId(user.getStoreId());
        cus.setStoreName(user.getStoreName());
        cus.setRealName(data.getRealName());
        cus.setIdCardNumber(data.getIdCardNumber());
        cus.setGender(DatetimeUtil.getGender(data.getIdCardNumber()));
        cus.setPhoneNumber(data.getPhoneNumber());
        cus.setLevel(data.getLevel());
        cus.setIntegral(data.getIntegral());
        cus.setBirthday(DatetimeUtil.getBirthday(data.getIdCardNumber()));
        cus.setIntroducer(data.getIntroducer());
        cus.setIntroducerId(data.getIntroducerId());
        cus.setCreateId(user.getId());
        cus.setCreatePerson(user.getRealName());
        cus.setRegistrationTime(DatetimeUtil.formatDate(new Date()));
        cus.setMoney(data.getMoney());
        cus.setEnable(true);
        customerDao.saveObject(cus);
        return  1;
    }

    public int edit(String authToken, CustomerJson data) {
        Customer c = customerDao.findById(data.getId());
        c.setRealName(data.getRealName());
        c.setPhoneNumber(data.getPhoneNumber());

        c.setIdCardNumber(data.getIdCardNumber());
        c.setGender(data.getGender());
        c.setLevel(data.getLevel());
        c.setIntegral(data.getIntegral());
        c.setBirthday(DatetimeUtil.parseDate(data.getBirthday()));
        c.setIntroducer(data.getIntroducer());
        c.setIntroducerId(data.getIntroducerId());
        c.setMoney(data.getMoney());
        c.setEnable(true);
        customerDao.updateObject(c);
        return  1;

    }


    public int recharge(String authToken, RechargeJson data) {
        Staff user = getStaffByAuthToken(authToken);
        Customer c = customerDao.findById(data.getCustomerId());
        c.setMoney(c.getMoney().add(data.getMoney()));
        Bill bill = new Bill();
        bill.setZfmoney(data.getMoney());
        bill.setStoreName(user.getStoreName());
        bill.setStoreId(user.getStoreId());
        bill.setCustomerId(c.getId());
        bill.setCustomer(c.getRealName());
        bill.setBillType("0");
        bill.setBillTime(new Date());
        bill.setEnable(true);
        bill.setPaymentMethod("1");
        customerDao.saveObject(bill);
        customerDao.updateObject(c);
        return 1;
    }

    public ResultsWrapper<CustomerListJson> findCustomerList(String authToken, String name, Integer page, Integer pageSize) {
        Staff user = getStaffByAuthToken(authToken);
        List<Customer> users = customerDao.findList(user.getStoreId(),name,page,pageSize);
        List<CustomerListJson> json = new ArrayList<CustomerListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new CustomerListJson(a)));
        }
        Long count = customerDao.findListCount(user.getStoreId(),name);

        ResultsWrapper<CustomerListJson> h = new ResultsWrapper<CustomerListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public CustomerListJson findById(Long id) {
        Customer c = customerDao.findById(id);
        CustomerListJson json = new CustomerListJson(c);

        return json;
    }

    public int delete(String authToken, Long id) {
        return customerDao.delete(id);
    }

    public ResultsWrapper<OwningCardListJson> findOwningCardById(Long id, Integer page, Integer pageSize) {


        List<OwningCard> users = customerDao.findOwningCard(id,page,pageSize);
        List<OwningCardListJson> json = new ArrayList<OwningCardListJson>();
        if (users.size()>0) {
            for(OwningCard u:users){
                OwningCardListJson own = new OwningCardListJson(u);
                Date date = new Date();
                if(date.getTime()<u.getEndTime().getTime()){
                    own.setCardStatus(u.getCardStatus());
                }else {
                    own.setCardStatus("3");
                    u.setCardStatus("3");
                    customerDao.updateObject(u);

                }
                json.add(own);
            }
//           users.forEach(a ->json.add(new OwningCardListJson(a)));
        }
        Long count = customerDao.findOwningCardCount(id);

        ResultsWrapper<OwningCardListJson> h = new ResultsWrapper<OwningCardListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public List<CustomerListJson> findAllCustomer(String authToken) {
        Staff user = getStaffByAuthToken(authToken);
        List<Customer> users = customerDao.findAllCustomer(user.getStoreId());
        List<CustomerListJson> json = new ArrayList<CustomerListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new CustomerListJson(a)));
        }
        return json;
    }




    public int doCard(String authToken, OwningCardJson data) {
     //   CustomerMembersEnjoy c = customerDao.findById(data.getCustomerId());
        CardManagement card =cardDao.findById(data.getCardId());
        OwningCard docard = new OwningCard();
        Date date =  new Date();
        int num = Integer.parseInt(card.getEffectiveTime());
        String t = DatetimeUtil.formatDatetime(date);
        Date end = DatetimeUtil.plusYear(num,t);
        docard.setCardId(card.getId());
        docard.setCardName(card.getName());
        docard.setCustomerId(data.getCustomerId());
        docard.setOpenTime(date);
        docard.setEndTime(end);
        docard.setCardStatus("1");
        List<MyProject> list = new ArrayList<>();
        for(CardProject c:card.getCardProject()){
            MyProject my = new MyProject();
            my.setProject(c.getProjectName());
            my.setProjectId(c.getProjectId());
            my.setRemaining(c.getFrequency());
            my.setCustomerId(data.getCustomerId());
            my.setCardId(card.getId());
            my.setCard(docard);
            list.add(my);
        }
        List<MyProduct> duct = new ArrayList<>();
        for(CardProduct c:card.getProduct()){
            MyProduct p = new MyProduct();
            p.setCardId(c.getCard().getId());
            p.setCustomerId(data.getCustomerId());
            p.setProduct(c.getProductName());
            p.setProductId(c.getProductId());
            p.setCard(docard);
            p.setRemaining(c.getNumber());
            duct.add(p);

        }
        docard.setProject(list);
        docard.setProduct(duct);
        cardDao.saveObject(card);

    return 1;
    }




    public ResultsWrapper<BillJson> findBillById(Long id,String paymentMethod, Integer page, Integer pageSize) {
        List<Bill> users = customerDao.findBillById(id,paymentMethod,page,pageSize);
        List<BillJson> json = new ArrayList<BillJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new BillJson(a)));
            for(Bill b:users){
                BillJson js = new BillJson(b);
                ServiceOrders s = serviceOrdersDao.findById(b.getServiceId());

                js.setAppoint(s.getAppoint());
                js.setCreateTime(DatetimeUtil.formatDate(s.getCreateTime()));
                js.setPreSale(s.getPreSale());
                js.setServiceRoom(s.getServiceRoom());
                js.setOperatorName(s.getOperatorName());
                List<ServiceProjectListJson> project = new ArrayList<>();
                List<ServiceCardProjectJson> cardProject  = new ArrayList<>();
                List<ServiceProductListJson>  product = new ArrayList<>();
                if(s.getProject() != null){
                    for(ServiceProject j:s.getProject()){
                        if(j.getCardId() == null){
                            project.add(new ServiceProjectListJson(j));
                        }else{
                            cardProject.add(new ServiceCardProjectJson(j));
                        }
                    }
                }
                js.setProject(project);

                js.setCardProject(cardProject);
                if(s.getProduct() != null){
                    for(ServiceProduct d:s.getProduct()){

                        product.add(new ServiceProductListJson(d));
                    }
                }
                js.setProduct(product);
                json.add(js);

            }

        }

        Long count = customerDao.findBillCount(id,paymentMethod);

        ResultsWrapper<BillJson> h = new ResultsWrapper<BillJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public List<ProblemDescriptionJson> findAllProblem() {
        List<ProblemDescriptionJson> pro = customerDao.findAllProblem();
        return pro;

    }

    public ResultsWrapper<MyProblemCheckJson> findMyProblem(String authToken,Long id,Integer page,Integer pageSize) {
        List<MyProblemCheck> pro = customerDao.findMyProblem(id,page,pageSize);
        List<MyProblemCheckJson> json = new ArrayList<MyProblemCheckJson>();
        if (pro.size()>0) {
            pro.forEach(a ->json.add(new MyProblemCheckJson(a)));
        }
        Long count = customerDao.findMyProblemCount(id);

        ResultsWrapper<MyProblemCheckJson> h = new ResultsWrapper<MyProblemCheckJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public int problemSave(String authToken, MyProblemJson data) {

        Customer c = customerDao.findById(data.getCustomerId());
        MyProblemCheck check = new MyProblemCheck();
        check.setCustomer(c.getRealName());
        check.setCustomerId(c.getId());
        check.setEnable(true);
        check.setProStatus("1");
        check.setCheckTime(new Date());
        check.setProgramme("0");
        check.setProids(data.getProids());
        String des="";
        for(int i=0;i<data.getProids().length;i++){
            ProblemDescription p = customerDao.findProblemById(data.getProids()[i]);
            if (!p.getProblem().equals("")) {
                des=des+p.getProblem()+",";
            }
        }
        check.setDescription(des.substring(0, des.length()-1));
        customerDao.saveObject(check);
        return 1;

    }

    public int problemBegin(String authToken, MyProblemJson data) {
        MyProblemCheck check = customerDao.findMyProblemById(data.getId());


        check.setProgramme(data.getProgramme());
        String desProgramme="";
        for(int i=0;i<check.getProids().length;i++) {
            List<CorrespondencePlan> plan = customerDao.findByProblem(check.getProids()[i],data.getProgramme());
            for(int j=0;j<plan.size();j++){
                if (!desProgramme.equals("")) {
                    desProgramme = desProgramme + "," + plan.get(j).getBasicProgram();
                }else {
                    desProgramme = ""+plan.get(j).getBasicProgram();
                }
            }
        }
        check.setProStatus("2");
        check.setDesProgramme(desProgramme);
        customerDao.saveObject(check);
        return 1;

    }

    public PlanJson findPlan(String type,Long id) {
        PlanJson json = new PlanJson();
        MyProblemCheck check = customerDao.findMyProblemById(id);

        String desProgramme="";
        String ids="";
        for(int i=0;i<check.getProids().length;i++) {
            List<CorrespondencePlan> plan = customerDao.findByProblem(check.getProids()[i],type);
            for(int j=0;j<plan.size();j++) {
                if (!desProgramme.equals("")){
                    desProgramme = desProgramme + "," + plan.get(j).getBasicProgram();
                }else{
                    desProgramme = plan.get(j).getBasicProgram();
                }
                if (!ids.equals("")){
                    ids = ids + "," + plan.get(j).getBasicProgramId();
                }else{
                    ids = ""+plan.get(j).getBasicProgramId();
                }
            }
        }
        String[] des = ids.split(",");
        Long[] de = new Long[des.length];
            for(int o=0;o<des.length;o++){
                de[o] = Long.valueOf(des[o]);
            }
        json.setDescription(desProgramme);
        json.setIds(de);
        return json;
    }

    public int completionPlan(String authToken, MyProblemJson data) {
        MyProblemCheck check = customerDao.findMyProblemById(data.getId());
        check.setCompletionPlan(data.getCompletionPlan());
        check.setCompletionTime(new Date());
        check.setProStatus("2");
        return 1;
    }

    public int addCard(String authToken, CardVO data) {
//        Staff user = getStaffByAuthToken(authToken);
        switch (data.getType()){
            case 1: addMembershipCard(data, 1, ProductEnum.MEMBERSHIPCARDMANAGEMENT.getMessage());break;
            case 2: addExtension(data, 2,  ProductEnum.EXTENSIONCARDMANAGEMENT.getMessage());break;
            case 3: addActivity(data, 3, ProductEnum.COURSEOFACTIVITYCARD.getMessage());break;
            case 4: addTreatment(data,4,  ProductEnum.PRODUCTCARDMANAGEMENT.getMessage());break;
            case 5: addProductCardManagement(data, 5, ProductEnum.PRODUCT.getMessage());break;
        }

        return 1;
    }


    public int addProductCardManagement(CardVO data, Integer num,  String name){
        ProductCardManagement card = productCardDao.findById(data.getCardId());
        OwningCard owningCard = setOwningCard(data, card.getProductCardValidity(), name, num);
        cardDao.save(owningCard);
        return 1;
    }
    @Resource
    private MembershipService membershipService;

    @Resource
    private ProjectService projectService;
    @Resource
    private MembersEnjoyService membersEnjoyService;
    public int addMembershipCard(CardVO data, Integer num, String name){
        MembershipCardManagement card = membershipService.findById(data.getCardId());
        OwningCard owningCard = setOwningCard(data, card.getMembershipValidity(), name, num);
        List<MyProduct> duct = new ArrayList<>();

        List<MyProject> ject = new ArrayList<>();
        for(MembersEnjoy e:card.getEnjoy()){
            ProjectManagement projectManagement = e.getProject();
            MyProject m = new MyProject();
            m.setCustomer(data.getUserName());
            m.setCustomerId(data.getUserId());
            m.setCardId(data.getCardId());
            m.setProject(projectManagement.getProjectName());
            m.setProjectId(projectManagement.getId());
            m.setRemaining(e.getEnjoyNumber());
            m.setCard(owningCard);
            ject.add(m);
            for(ProjectProduct c:projectManagement.getProduct()){
                MyProduct p = new MyProduct();
                p.setCardId(c.getId());
                p.setCustomer(data.getUserName());
                p.setCustomerId(data.getUserId());
                p.setProduct(c.getProductName());
                p.setProductId(c.getProductId());
                p.setCard(owningCard);
                p.setRemaining(1);
                duct.add(p);
            }
        }
        owningCard.setProduct(duct);
        owningCard.setProject(ject);
        cardDao.save(owningCard);
        return 1;
    }

    //拓展卡
    public int addExtension(CardVO data, Integer num, String name){
        ExtensionCardManagement card = extensionService.findById(data.getCardId());
        OwningCard owningCard = setOwningCard(data, card.getExtensionValidity(), name, num);

        List<MyProduct> duct = new ArrayList<>();
        List<MyProject> ject = new ArrayList<>();
        for(ExtensionCardProject e:card.getProject()){
            ProjectManagement projectManagement = e.getProject();
            List<ProjectProduct> projectProducts = projectManagement.getProduct();
            MyProject m = new MyProject();
            m.setCustomer(data.getUserName());
            m.setCustomerId(data.getUserId());
            m.setCardId(data.getCardId());
            m.setProject(projectManagement.getProjectName());
            m.setProjectId(projectManagement.getId());
            m.setRemaining(e.getExtensionNumber());
            m.setCard(owningCard);
            ject.add(m);
            for(ProjectProduct c:projectProducts){
                MyProduct p = new MyProduct();
                p.setCardId(c.getId());
                p.setCustomer(data.getUserName());
                p.setCustomerId(data.getUserId());
                p.setProduct(c.getProductName());
                p.setProductId(c.getProductId());
                p.setCard(owningCard);
                p.setRemaining(1);
                duct.add(p);
            }
        }
        owningCard.setProject(ject);
        owningCard.setProduct(duct);
        cardDao.save(owningCard);
        return 1;
    }
    //活动卡
    public int addActivity(CardVO data, Integer num, String name){
        ActivityCardManagement card = activityService.findById(data.getCardId());
        OwningCard owningCard = setOwningCard(data, card.getActivityValidity(), name, num);

        List<MyProduct> duct = new ArrayList<>();
        List<MyProject> ject = new ArrayList<>();
        for(ActivityProject e:card.getProject()){
            ProjectManagement projectManagement = e.getProject();
            MyProject m = new MyProject();
            m.setCustomer(data.getUserName());
            m.setCustomerId(data.getUserId());
            m.setCardId(data.getCardId());
            m.setProject(projectManagement.getProjectName());
            m.setProjectId(projectManagement.getId());
            m.setRemaining(e.getActivityNumber());
            m.setCard(owningCard);
            ject.add(m);
            for(ProjectProduct c:projectManagement.getProduct()){
                MyProduct p = new MyProduct();
                p.setCardId(c.getId());
                p.setCustomer(data.getUserName());
                p.setCustomerId(data.getUserId());
                p.setProduct(c.getProductName());
                p.setProductId(c.getProductId());
                p.setCard(owningCard);
                p.setRemaining(1);
                duct.add(p);
            }
        }
        owningCard.setProduct(duct);
        owningCard.setProject(ject);
        cardDao.save(owningCard);

        return 1;
    }
    //疗程组合卡
    public int addTreatment(CardVO data, Integer num, String name){
        TreatmentCardManagement card = treatmentService.findById(data.getCardId());
        OwningCard owningCard = setOwningCard(data, card.getTreatmentCardValidity(), name, num);

        List<MyProduct> duct = new ArrayList<>();
        List<MyProject> ject = new ArrayList<>();
        for(ExtensionCardProject e:card.getProject()){
            ProjectManagement projectManagement = e.getProject();
            MyProject m = new MyProject();
            m.setCustomer(data.getUserName());
            m.setCustomerId(data.getUserId());
            m.setCardId(data.getCardId());
            m.setProject(projectManagement.getProjectName());
            m.setProjectId(projectManagement.getId());
            m.setRemaining(e.getExtensionNumber());
            m.setCard(owningCard);
            ject.add(m);
            for(ProjectProduct c:projectManagement.getProduct()){
                MyProduct p = new MyProduct();
                p.setCardId(c.getId());
                p.setCustomer(data.getUserName());
                p.setCustomerId(data.getUserId());
                p.setProduct(c.getProductName());
                p.setProductId(c.getProductId());
                p.setCard(owningCard);
                p.setRemaining(1);
                duct.add(p);
            }
        }
        owningCard.setProduct(duct);
        owningCard.setProject(ject);
        cardDao.save(owningCard);
        return 1;
    }
    //通用设置
    public OwningCard setOwningCard(CardVO data, Integer num, String mesage, Integer type){
        OwningCard owningCard = new OwningCard();
        owningCard.setCustomerId(data.getUserId());
        owningCard.setCardId(data.getCardId());
        owningCard.setCardName(data.getCardName());
        owningCard.setEnable(true);
        owningCard.setOpenTime(new Date());
        owningCard.setCardStatus("1");
        owningCard.setCardType(type);
        owningCard.setCardTypeName(mesage);
        Date date =  new Date();
        String t = DatetimeUtil.formatDatetime(date);
        Date end = DatetimeUtil.plusYear(num,t);
        owningCard.setEndTime(end);
        owningCard.setBz(data.getBz());
        return owningCard;
    }



}
