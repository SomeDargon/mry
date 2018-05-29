package com.mry.service.store;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ProjectDao;
import com.mry.entity.dao.system.MembershipDao;
import com.mry.entity.store.card.MembershipCardManagement;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.entity.store.project.ProjectProduct;
import com.mry.entity.user.Staff;
import com.mry.json.ResultsWrapper;
import com.mry.json.store.ProjectJson;
import com.mry.json.store.ProjectListJson;
import com.mry.json.store.ProjectProductJson;
import com.mry.json.store.ProjectProductNewJson;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/11/1.
 */
@Service
@Transactional
public class ProjectService extends BaseService {

    @Resource
    public ProjectDao projectDao;

    @Resource
    public MembershipDao membershipDao;

    @Resource
    public StoreDao storeDao;

    public int save(String authToken, ProjectJson data) {
   //     Staff user = getStaffByAuthToken(authToken);
        StoreManagement s = storeDao.findById(data.getStoreId());
        ProjectManagement p = new ProjectManagement();
        p.setProjectName(data.getProjectName());
        p.setCode(data.getCode());
        if(data.getCashMoney()!= null) {
            p.setCashMoney(new BigDecimal(data.getCashMoney()));
        }
        if(data.getCourseMoney()!= null) {
            p.setCourseMoney(new BigDecimal(data.getCourseMoney()));
        }
        if(data.getBuckleMoney()!= null) {
            p.setBuckleMoney(new BigDecimal(data.getBuckleMoney()));
        }

        if(data.getIsCalculate() == "0"){
            MembershipCardManagement card = membershipDao.findMinMembershipCardById(data.getStoreId());
            if(data.getCashMoney()!= null) {

                BigDecimal num1 = new BigDecimal(data.getCashMoney());
                BigDecimal num2 = BigDecimal.valueOf(card.getProjectDiscount());
                p.setExperienceMoney(num1.multiply(num2));
                p.setIsCalculate("0");
            }

        }else{
            if(data.getExperienceMoney()!= null) {
                p.setExperienceMoney(new BigDecimal(data.getExperienceMoney()));
                p.setIsCalculate("1");
            }
        }
        p.setEnable(true);
        p.setStoreId(s.getId());
        p.setStoreName(s.getStoreName());
        p.setIsCalculate(data.getIsCalculate());
        p.setEffect(data.getEffect());
        p.setType(data.getType());
        p.setProjectDescription(data.getProjectDescription());
        p.setTechnicalPoints(data.getTechnicalPoints());
        p.setCollocationItems(data.getCollocationItems());
        p.setProjectAttributes(data.getProjectAttributes());
        p.setFrequency(data.getFrequency());
        p.setIntervalTime(data.getIntervalTime());
//        p.setOperator(user.getRealName());
//        p.setOperatorId(user.getId());
        p.setOperator(DatetimeUtil.formatDate(new Date()));
        if(data.getProduct() != null){
            List<ProjectProduct> list = new ArrayList<>();
            for (ProjectProductNewJson item : data.getProduct()) {
                ProjectProduct temp = item.convert();
                temp.setProject(p);
                list.add(temp);
            }
//            p.setProduct(list);

        }
        projectDao.saveObject(p);
        return  1;
    }

    public int edit(String authToken, ProjectJson data) {
     //   Staff user = getStaffByAuthToken(authToken);
        StoreManagement s = storeDao.findById(data.getStoreId());
        ProjectManagement p = projectDao.findById(data.getId());
        projectDao.deleteProduct(data.getId());
        p.setProjectName(data.getProjectName());
        p.setCode(data.getCode());
        p.setCode(data.getCode());
        if(data.getCashMoney()!= null) {
            p.setCashMoney(new BigDecimal(data.getCashMoney()));
        }
        if(data.getCourseMoney()!= null) {
            p.setCourseMoney(new BigDecimal(data.getCourseMoney()));
        }
        if(data.getBuckleMoney()!= null) {
            p.setBuckleMoney(new BigDecimal(data.getBuckleMoney()));
        }
        if(data.getIsCalculate() == "0" || data.getIsCalculate() !=null){
            MembershipCardManagement card = membershipDao.findMinMembershipCardById(data.getStoreId());
            if(card != null )
            if(data.getCashMoney()!= null) {

                BigDecimal num1 = new BigDecimal(data.getCashMoney());
                BigDecimal num2 = BigDecimal.valueOf(card.getProjectDiscount());
                p.setExperienceMoney(num1.multiply(num2));
                p.setIsCalculate("0");
            }

        }else{
            if(data.getExperienceMoney()!= null) {
                p.setExperienceMoney(new BigDecimal(data.getExperienceMoney()));
                p.setIsCalculate("1");
            }
        }
        p.setStoreId(s.getId());
        p.setStoreName(s.getStoreName());

        p.setEffect(data.getEffect());
        p.setType(data.getType());

        p.setProjectDescription(data.getProjectDescription());
        p.setTechnicalPoints(data.getTechnicalPoints());
        p.setCollocationItems(data.getCollocationItems());
        p.setProjectAttributes(data.getProjectAttributes());
        p.setFrequency(data.getFrequency());
        p.setIntervalTime(data.getIntervalTime());
//        p.setUpdatePeople(user.getRealName());
//        p.setUpdatePeopleId(user.getId());
        p.setModifierTime(DatetimeUtil.formatDate(new Date()));
        if(data.getProduct() != null){
            List<ProjectProduct> list = new ArrayList<>();
            for (ProjectProductNewJson item : data.getProduct()) {
                ProjectProduct temp = item.convert();
                temp.setProject(p);
                list.add(temp);
            }
//            p.setProduct(list);

        }
        p.setEnable(true);
        projectDao.updateObject(p);
        return  1;
    }

    public ResultsWrapper<ProjectListJson> findProjectList(Long id, String name, Integer page, Integer pageSize) {

       // Staff user = getStaffByAuthToken(authToken);
        List<ProjectManagement> users = projectDao.findList(id,name,page,pageSize);
        List<ProjectListJson> json = new ArrayList<ProjectListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new ProjectListJson(a)));
        }
        Long count = projectDao.findListCount(id,name);

        ResultsWrapper<ProjectListJson> h = new ResultsWrapper<ProjectListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public ProjectListJson findById(Long id) {
        ProjectManagement p = projectDao.findById(id);
        ProjectListJson json = new ProjectListJson(p);
        return json;
    }

    public ProjectManagement getById(Long id) {
        return  projectDao.findById(id);
    }

    public int delete(String authToken, Long id) {

        return projectDao.delete(id);
    }

    public List<ProjectListJson> findAllProjectt(Long storeId) {

      //  Staff user = getStaffByAuthToken(authToken);
        List<ProjectManagement> users = projectDao.findAllProjectt(storeId);
        List<ProjectListJson> json = new ArrayList<ProjectListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new ProjectListJson(a)));
        }
        return json;
    }
}
