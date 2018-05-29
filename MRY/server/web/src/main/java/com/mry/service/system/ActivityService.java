package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ProjectDao;
import com.mry.entity.dao.system.ActivityDao;
import com.mry.entity.dao.system.EntryDao;
import com.mry.entity.dao.system.ProductDao;
import com.mry.entity.dao.system.TreatmentDao;
import com.mry.entity.store.card.*;
import com.mry.entity.store.project.ProductManagement;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.json.system.ActivityJson;
import com.mry.json.system.MembershipListJson;
import com.mry.json.system.activity.*;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2018/1/11.
 */
@Service
@Transactional
public class ActivityService extends BaseService {

    @Resource
    public ActivityDao activityDao;

    @Resource
    public StoreDao storeDao;

    @Resource
    public ProjectDao projectDao;

    @Resource
    public TreatmentDao treatmentDao;

    @Resource
    private ProductDao productDao;


    public ActivityCardManagement findById(Long id){
        return activityDao.findById(id);
    }

    public int save(ActivityJson data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        ActivityCardManagement a = new ActivityCardManagement();
        a.setStoreId(s.getId());
        a.setStoreName(s.getStoreName());
        a.setActivityValidity(data.getActivityValidity());
        a.setActivityName(data.getActivityName());
        if(data.getEndTime() != null) {
            a.setEndTime(DatetimeUtil.parseDate(data.getEndTime()));
        }

        if(data.getBeginTime() != null) {
            a.setBeginTime(DatetimeUtil.parseDate(data.getBeginTime()));
        }
        if(data.getActivityBucklePrice() != null && data.getActivityBucklePrice()!="") {
            a.setActivityBucklePrice(new BigDecimal(data.getActivityBucklePrice()));
        }
        //活动卡现金金额
        if(data.getActivityCashPrice() != null && data.getActivityCashPrice()!="") {
            a.setActivityCashPrice(new BigDecimal(data.getActivityCashPrice()));
        }
   //     a.setActivityCardValidity(data.getActivityCardValidity());
        if(data.getReturnAmount() != null && data.getReturnAmount()!="") {
            a.setReturnAmount(new BigDecimal(data.getReturnAmount()));
        }
        a.setReturnMode(data.getReturnMode());
        a.setReturnValidity(data.getReturnValidity());
        a.setMemberDayNtoStore(data.getMemberDayNtoStore());

        if(data.getProject() != null){
            List<ActivityProject> aps = new ArrayList<>();
            for(ActivityProjectJson j:data.getProject()){
                ActivityProject ap = new ActivityProject();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    ap.setProject(ject);
                }

                ap.setActivityNumber(j.getActivityNumber());
                ap.setActivityValidity(data.getActivityValidity());
                ap.setActivity(a);

                aps.add(ap);
            }
            a.setProject(aps);
        }
        if(data.getNewCustomerParticipation() != null){
            List<NewCustomerParticipation> aps = new ArrayList<>();
            for(NewCustomerParticipationJson j :data.getNewCustomerParticipation()){
                NewCustomerParticipation ap = new NewCustomerParticipation();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    ap.setProject(ject);
                }

                ap.setActivityNumber(j.getActivityNumber());
               // ap.setActivityValidity(data.getActivityValidity());
                ap.setActivity(a);

                aps.add(ap);
            }
            a.setNewCustomerParticipation(aps);
        }
        if(data.getApecialSecondKill() != null){
            List<SpecialSecondKill> sks = new ArrayList<>();
            for(SpecialSecondKillJson j:data.getApecialSecondKill()) {
                SpecialSecondKill sk = new SpecialSecondKill();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    sk.setProject(ject);
                }
                sk.setActivity(a);

                if(j.getSpecialMoney() != null && j.getSpecialMoney()!="") {
                    sk.setSpecialMoney(new BigDecimal(j.getSpecialMoney()));
                }
                sk.setSpecialNumber(j.getSpecialNumber());
                sks.add(sk);
            }
           a.setApecialSecondKill(sks);
        }

        if(data.getToStoreProject() != null){
            List<ToStoreProject> sks = new ArrayList<>();
            for(ToStoreProjectJson j:data.getToStoreProject()) {
                ToStoreProject sk = new ToStoreProject();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    sk.setProject(ject);
                }
                sk.setActivity(a);

                sk.setActivityNumber(j.getActivityNumber());
                sks.add(sk);
            }
            a.setToStoreProject(sks);
        }

        if(data.getCourseOfActivityCard() != null){
            List<CourseOfActivityCard> sks = new ArrayList<>();
            for(CourseOfActivityCardJson j:data.getCourseOfActivityCard()) {
                CourseOfActivityCard sk = new CourseOfActivityCard();
                if(j.getTreatmentId() != null) {
                    TreatmentCardManagement tean = treatmentDao.findById(j.getTreatmentId());
                    sk.setTreatment(tean);
                }
                sk.setActivity(a);


                sks.add(sk);
            }
            a.setCourseOfActivityCard(sks);
        }

        if(data.getProductSecondKill() != null){
            List<ProductSecondKill> sks = new ArrayList<>();
            for(ProductSecondKillJson j:data.getProductSecondKill()) {
                ProductSecondKill sk = new ProductSecondKill();
                if(j.getProjectId() != null) {
                    ProductManagement tean = productDao.findById(j.getProjectId());
                    sk.setProduct(tean);
                }
                sk.setActivity(a);

                if(j.getBuckleTheSecondPrice() != null && j.getBuckleTheSecondPrice()!="") {
                    sk.setBuckleTheSecondPrice(new BigDecimal(j.getBuckleTheSecondPrice()));
                }
                if(j.getCashSecondPrice() != null && j.getCashSecondPrice()!="") {
                    sk.setCashSecondPrice(new BigDecimal(j.getCashSecondPrice()));
                }

                sks.add(sk);
            }
            a.setProductSecondKill(sks);
        }
        a.setEnable(true);
        activityDao.saveObject(a);
        return 1;



    }

    public int edit(ActivityJson data) {

        StoreManagement s = storeDao.findById(data.getStoreId());
        ActivityCardManagement a = activityDao.findById(data.getId());
        a.setStoreId(s.getId());
        a.setStoreName(s.getStoreName());
        a.setActivityValidity(data.getActivityValidity());
        a.setActivityName(data.getActivityName());
        if(data.getActivityBucklePrice() != null && data.getActivityBucklePrice()!="") {
            a.setActivityBucklePrice(new BigDecimal(data.getActivityBucklePrice()));
        }
        //活动卡现金金额
        if(data.getActivityCashPrice() != null && data.getActivityCashPrice()!="") {
            a.setActivityCashPrice(new BigDecimal(data.getActivityCashPrice()));
        }
        if(data.getEndTime() != null) {
            a.setEndTime(DatetimeUtil.parseDate(data.getEndTime()));
        }

        if(data.getBeginTime() != null) {
            a.setBeginTime(DatetimeUtil.parseDate(data.getBeginTime()));
        }
     //   a.setActivityCardValidity(data.getActivityCardValidity());
        if(data.getReturnAmount() != null && data.getReturnAmount()!="") {
            a.setReturnAmount(new BigDecimal(data.getReturnAmount()));
        }
        a.setReturnMode(data.getReturnMode());
        a.setReturnValidity(data.getReturnValidity());
        a.setMemberDayNtoStore(data.getMemberDayNtoStore());
        activityDao.deleteProject(data.getId());
        if(data.getProject() != null){
            List<ActivityProject> aps = new ArrayList<>();
            for(ActivityProjectJson j:data.getProject()){
                ActivityProject ap = new ActivityProject();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    ap.setProject(ject);
                }
                ap.setActivityNumber(j.getActivityNumber());
                ap.setActivityValidity(data.getActivityValidity());
                ap.setActivity(a);
                aps.add(ap);
            }
            a.setProject(aps);
        }

        activityDao.deleteNewCustomerParticipation(data.getId());
        if(data.getNewCustomerParticipation() != null){
            List<NewCustomerParticipation> aps = new ArrayList<>();
            for(NewCustomerParticipationJson j :data.getNewCustomerParticipation()){
                NewCustomerParticipation ap = new NewCustomerParticipation();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    ap.setProject(ject);
                }
                ap.setActivityNumber(j.getActivityNumber());
                // ap.setActivityValidity(data.getActivityValidity());
                ap.setActivity(a);

                aps.add(ap);
            }
            a.setNewCustomerParticipation(aps);
        }


        activityDao.deleteApecialSecondKill(data.getId());
        if(data.getApecialSecondKill() != null){
            List<SpecialSecondKill> sks = new ArrayList<>();
            for(SpecialSecondKillJson j:data.getApecialSecondKill()) {
                SpecialSecondKill sk = new SpecialSecondKill();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    sk.setProject(ject);
                }
                sk.setActivity(a);

                if(j.getSpecialMoney() != null && j.getSpecialMoney()!="") {
                    sk.setSpecialMoney(new BigDecimal(j.getSpecialMoney()));
                }
                sk.setSpecialNumber(j.getSpecialNumber());
                sks.add(sk);
            }
            a.setApecialSecondKill(sks);
        }
        activityDao.deleteToStoreProject(data.getId());
        if(data.getToStoreProject() != null){
            List<ToStoreProject> sks = new ArrayList<>();
            for(ToStoreProjectJson j:data.getToStoreProject()) {
                ToStoreProject sk = new ToStoreProject();
                if(j.getProjectId() != null) {
                    ProjectManagement ject = projectDao.findById(j.getProjectId());
                    sk.setProject(ject);
                }
                sk.setActivity(a);

                sk.setActivityNumber(j.getActivityNumber());
                sks.add(sk);
            }
            a.setToStoreProject(sks);
        }
        activityDao.deleteCourseOfActivityCard(data.getId());
        if(data.getCourseOfActivityCard() != null){
            List<CourseOfActivityCard> sks = new ArrayList<>();
            for(CourseOfActivityCardJson j:data.getCourseOfActivityCard()) {
                CourseOfActivityCard sk = new CourseOfActivityCard();
                if(j.getTreatmentId() != null) {
                    TreatmentCardManagement tean = treatmentDao.findById(j.getTreatmentId());
                    sk.setTreatment(tean);
                }
                sk.setActivity(a);
                sks.add(sk);
            }
            a.setCourseOfActivityCard(sks);
        }
        activityDao.deleteProductSecondKill(data.getId());
        if(data.getProductSecondKill() != null){
            List<ProductSecondKill> sks = new ArrayList<>();
            for(ProductSecondKillJson j:data.getProductSecondKill()) {
                ProductSecondKill sk = new ProductSecondKill();
                if(j.getProjectId() != null) {
                    ProductManagement tean = productDao.findById(j.getProjectId());
                    sk.setProduct(tean);
                }
                sk.setActivity(a);

                if(j.getBuckleTheSecondPrice() != null && j.getBuckleTheSecondPrice()!="" ) {
                    sk.setBuckleTheSecondPrice(new BigDecimal(j.getBuckleTheSecondPrice()));
                }
                if(j.getCashSecondPrice() != null && j.getCashSecondPrice()!="") {
                    sk.setCashSecondPrice(new BigDecimal(j.getCashSecondPrice()));
                }

                sks.add(sk);
            }
            a.setProductSecondKill(sks);
        }
        a.setEnable(true);
        activityDao.updateObject(a);
        return 1;
    }

    public List<ActivityListJson> findactivity(Long id, String name) {
        List<ActivityListJson> list = new ArrayList<ActivityListJson>();
        List<ActivityCardManagement> users = activityDao.findactivity(id,name);
        if (users.size()>0) {
            users.forEach(a ->list.add(new ActivityListJson(a)));
        }

        return list;
    }

    public void delete(Long id) {
        activityDao.delete(id);
    }
}
