package com.mry.entity.dto;

import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;
import com.mry.entity.system.ShopDailyDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by somedragon on 2018/5/29.
 */
public  class DailyDetails {

    public static Map<String, Object> getValue(ShopDailyDetails s, ServiceOrders serviceOrders){
        Map<String, Object> map = null;
        //判断结算的服务
        if(serviceOrders.getServiceType().equals("2")) {
            map = new LinkedHashMap<>();
            //现金业绩
            if (serviceOrders.getOrderType().equals("0") || serviceOrders.getOrderType().equals("2")) {
                map.put("cashPerformance", serviceOrders.getCashAmount());
            }
            //员工姓名
            if (s.getEmployeeName()) {
                map.put("name", serviceOrders.getOperatorName());
            }
            //客户姓名
            if (s.getCustomerName()) {
                map.put("userName", serviceOrders.getCustomer());
            }
            //产品现金
            if (s.getProductCash()) {
                List<ServiceProduct> serviceProducts = serviceOrders.getProduct();
                BigDecimal productCash = new BigDecimal(0.0);
                for (ServiceProduct serviceProduct : serviceProducts) {
                    if (serviceProduct.getCardId() == null && serviceProduct.getCardId().equals("")) {
                        productCash = productCash.add(serviceProduct.getMoney());
                    }
                }
                map.put("productCash", productCash);
            }
            //产品卡扣
            if (s.getProductSnap()) {
                List<ServiceProduct> serviceProducts = serviceOrders.getProduct();
                BigDecimal productSnap = new BigDecimal(0.0);
                for (ServiceProduct serviceProduct : serviceProducts) {
                    if (serviceProduct.getCardId() != null && !serviceProduct.getCardId().equals("")) {
                        productSnap = productSnap.add(serviceProduct.getMoney());
                    }
                }
                map.put("productSnap", productSnap);
            }
            //服务项目
            if (s.getServiceItems()) {
                List<ServiceProject> serviceProjects = serviceOrders.getProject();
                List<String> projects = new ArrayList<>();
                for (ServiceProject serviceProject : serviceProjects) {
                    projects.add(serviceProject.getProjectName());
                }
                map.put("serviceItems", projects);
            }
            //卡扣疗程名称 || 卡扣疗程金额
            if (s.getClaspCourseName() || s.getClaspCourseMoney()) {
                List<ServiceProject> serviceProjects = serviceOrders.getProject();
                List<String> projects = new ArrayList<>();
                List<BigDecimal> money = new ArrayList<>();
                for (ServiceProject serviceProject : serviceProjects) {
                    if (serviceProject.getCardId() != null && !serviceProject.getCardId().equals("")) {
                        projects.add(serviceProject.getProjectName());
                        money.add(serviceProject.getMoney());
                    }
                }
                //卡扣疗程名称
                if (s.getClaspCourseName()) {
                    map.put("claspCourseName", projects);
                }
                //卡扣疗程金额
                if (s.getClaspCourseMoney()) {
                    map.put("claspCourseMoney", money);
                }
            }

            //面部指定
            if (s.getFacialPracticeAppoint()) {
                map.put("fPAppoint", serviceOrders.getAppoint().equals("0") ? "未指定" : "指定");
            }
            //面部非指定
            if (s.getFacialPracticeNonSpecifiedt()) {
                map.put("fPNSpecifiedt", serviceOrders.getAppoint().equals("0") ? "指定" : "未指定");
            }
            //身体指定
            if (s.getPhysicalExerciseAppoint()) {
                map.put("pEAppoint", serviceOrders.getAppoint().equals("0") ? "未指定" : "指定");
            }
            //身体非指定
            if (s.getPhysicalExerciseNonSpecifiedt()) {
                map.put("pENSpecifiedt", serviceOrders.getAppoint().equals("0") ? "指定" : "未指定");
            }
        }
        return map;
    }

    /**
     * 获取标题
     * @param s
     * @return
     */
    public static List<String> getTitle(ShopDailyDetails s ){

        List<String> title = new ArrayList<>();
        //现金业绩
        if(s.getCashPerformance()){
            title.add("cashPerformance");
        }
        //员工姓名
        if(s.getEmployeeName()){
            title.add("name");
        }
        //客户姓名
        if(s.getCustomerName()){
            title.add("userName");
        }
        //产品现金
        if(s.getProductCash()){
            title.add("productCash");
        }

        //产品卡扣
        if(s.getProductSnap()){
            title.add("productSnap");
        }
        //服务项目
        if(s.getServiceItems()){
            title.add("serviceItems");
        }
        //卡扣疗程名称
        if(s.getClaspCourseName()){
            title.add("claspCourseName");
        }
        //卡扣疗程金额
        if(s.getClaspCourseMoney()){
            title.add("claspCourseMoney");
        }
        //面部指定
        if(s.getFacialPracticeAppoint()){
            title.add("fPAppoint");
        }
        //面部非指定
        if(s.getFacialPracticeNonSpecifiedt()){
            title.add("fPNSpecifiedt");
        }
        //身体指定
        if(s.getPhysicalExerciseAppoint()){
            title.add("pEAppoint");
        }
        //身体非指定
        if(s.getPhysicalExerciseNonSpecifiedt()){
            title.add("pENSpecifiedt");
        }
        return title;
    }
}
