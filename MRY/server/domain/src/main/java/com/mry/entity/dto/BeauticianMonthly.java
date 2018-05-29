package com.mry.entity.dto;

import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;
import com.mry.entity.system.BeauticianMonthlyReport;
import com.mry.entity.user.Staff;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by somedragon on 2018/5/28.
 * 技师报 内容详情
 */
@Data
public class BeauticianMonthly {
    //客流
    Integer passengerNum = 0;
    //存储业绩
    BigDecimal storagePerformance = new BigDecimal(0);
    //现金疗程
    BigDecimal cashCourse = new BigDecimal(0);
    //卡业绩
    BigDecimal cardPerformance = new BigDecimal(0);
    //面部实操指定
    Integer facialPracticeAppoint = 0;
    //面部实操非指定
    Integer facialPracticeNonSpecifiedt = 0;
    //身体实操指定
    Integer physicalExerciseAppoint = 0;
    //身体实操非指定
    Integer physicalExerciseNonSpecifiedt = 0;
    //产品现金
    BigDecimal productCash = new BigDecimal(0);
    //产品卡扣
    BigDecimal productSnap = new BigDecimal(0);
    //赠送手工
    BigDecimal giveHandToHand = new BigDecimal(0);
    //项目现金
    BigDecimal projectCash = new BigDecimal(0);
    //项目卡扣
    BigDecimal projectSnap = new BigDecimal(0);
    //转介绍业绩
    BigDecimal introducePerformance = new BigDecimal(0);



    /**
     * 根据BeauticianMonthly 中的条件生成数据
     * @param b
     * @param s
     * @return
     */
    public static Map<String, Object> getData(BeauticianMonthly b, BeauticianMonthlyReport s){
        Map<String, Object> map = new HashMap<>();
        if (s.getPassenger()){
            map.put("passenger", b.getPassengerNum());
        }
        if (s.getStoragePerformance()){
            map.put("storagePerformance", b.getStoragePerformance());
        }
        if (s.getCashCourse()){
            map.put("cashCourse", b.getCashCourse());
        }
        if (s.getCardPerformance()){
            map.put("cardPerformance", b.getCardPerformance());
        }
        if (s.getFacialPracticeAppoint()){
            map.put("facialPracticeAppoint", b.getFacialPracticeAppoint());
        }
        if (s.getFacialPracticeNonSpecifiedt()){
            map.put("facialPracticeNonSpecifiedt", b.getFacialPracticeNonSpecifiedt());
        }
        if (s.getPhysicalExerciseAppoint()){
            map.put("physicalExerciseAppoint", b.getPhysicalExerciseAppoint());
        }
        if (s.getPhysicalExerciseNonSpecifiedt()){
            map.put("physicalExerciseNonSpecifiedt", b.getPhysicalExerciseNonSpecifiedt());
        }
        if (s.getProductCash()){
            map.put("productCash", b.getProductCash());
        }
        if (s.getProductSnap()){
            map.put("productSnap", b.getProductSnap());
        }
        if (s.getGiveHandToHand()){
            map.put("giveHandToHand", b.getGiveHandToHand());
        }
        if (s.getIntroducePerformance()){
            map.put("introducePerformance", b.getIntroducePerformance());
        }
        if (s.getProjectCash()){
            map.put("projectCash", b.getProjectCash());
        }
        if (s.getProjectSnap()){
            map.put("projectSnap", b.getProjectSnap());
        }
        return  map;
    }

    /**
     * 根据BeauticianMonthly 中的条件生成头部
     * @param s
     * @return
     */
    public static List<String> getTitle(BeauticianMonthlyReport s){
        List<String> title = new ArrayList<>();
        if (s.getPassenger()){
            title.add("passenger");
        }
        if (s.getStoragePerformance()){
            title.add("storagePerformance");
        }
        if (s.getCashCourse()){
            title.add("cashCourse");
        }
        if (s.getCardPerformance()){
            title.add("cardPerformance");
        }
        if (s.getFacialPracticeAppoint()){
            title.add("facialPracticeAppoint");
        }
        if (s.getFacialPracticeNonSpecifiedt()){
            title.add("facialPracticeNonSpecifiedt");
        }
        if (s.getPhysicalExerciseAppoint()){
            title.add("physicalExerciseAppoint");
        }
        if (s.getPhysicalExerciseNonSpecifiedt()){
            title.add("physicalExerciseNonSpecifiedt");
        }
        if (s.getProductCash()){
            title.add("productCash");
        }
        if (s.getProductSnap()){
            title.add("productSnap");
        }
        if (s.getGiveHandToHand()){
            title.add("giveHandToHand");
        }
        if (s.getIntroducePerformance()){
            title.add("introducePerformance");
        }
        if (s.getProjectCash()){
            title.add("projectCash");
        }
        if (s.getProjectSnap()){
            title.add("projectSnap");
        }
        return title;
    }

    /**
     *  算出计算技师月统计数据
     * @param b
     * @param service
     * @param customer
     */
    public static void setData(BeauticianMonthly b, ServiceOrders service, Staff customer){
        //消费单
        if(service.getOrderType().equals("2") && service.getOperatorId().equals(customer.getId())) {
            b.setPassengerNum(b.getPassengerNum()+1);
            //存储业绩
            if (service.getPaymentMethod().equals("0")) {
                b.setStoragePerformance(b.getStoragePerformance().add(service.getCashAmount()))  ;
            }
            //现金疗程
            if (service.getPaymentMethod().equals("1")) {
                b.setCashCourse(b.getCashCourse().add(service.getCashAmount()));
            }
            //卡扣金额
            b.setCardPerformance(b.getCardPerformance().add(service.getSavingsAmount()));
            //面部指定 面部非指定 身体指定 身体非指定
            if (service.getAppoint().equals("0")) {
                b.setFacialPracticeAppoint(b.getFacialPracticeAppoint()+1);
                b.setPhysicalExerciseAppoint(b.getPhysicalExerciseAppoint()+1);
            } else {
                b.setFacialPracticeNonSpecifiedt(b.getFacialPracticeNonSpecifiedt()+1);
                b.setPhysicalExerciseNonSpecifiedt(b.getPhysicalExerciseNonSpecifiedt()+1);
            }
            List<ServiceProduct> serviceProducts = service.getProduct();
            if (serviceProducts != null) {
                for (ServiceProduct serviceProduct : serviceProducts) {
                    //产品现金
                    if (serviceProduct.getCardId() == null && serviceProduct.getCardId().equals("")) {
                        b.setProductCash(b.getProjectCash().add(serviceProduct.getMoney()));
                    }
                    //产品卡扣
                    if (serviceProduct.getCardId() != null && !serviceProduct.getCardId().equals("")) {
                        b.setProductSnap(b.getProjectSnap().add(serviceProduct.getMoney()));
                    }
                }
            }
            List<ServiceProject> serviceProjects = service.getProject();
            if (serviceProjects != null) {
                for (ServiceProject serviceProject : serviceProjects) {
                    //产品现金
                    if (serviceProject.getCardId() == null && serviceProject.getCardId().equals("")) {
                        b.setProjectCash(b.getProjectCash().add(serviceProject.getMoney()));
                    }
                    //产品卡扣
                    if (serviceProject.getCardId() != null && !serviceProject.getCardId().equals("")) {
                        b.setProjectSnap(b.getProjectSnap().add(serviceProject.getMoney()));
                    }
                }
            }
        }
    }

}
