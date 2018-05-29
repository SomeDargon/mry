package com.mry.entity.dto;

import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;
import com.mry.entity.system.ManagerOfTheMonthlyReport;
import com.mry.entity.user.Staff;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by somedragon on 2018/5/28.
 */
@Data
public class MonthDetails {
    /** 全店业绩 */
    BigDecimal totalMoney = new BigDecimal(0);
    /** 全店客流 */
    Integer peopleTotal = 0;
    /** 全店实操 */
    BigDecimal actualTotal = new BigDecimal(0);
    /** 全店到店人数 */
    Integer goSotreNum = 0;
    /** 高端项目 */
    Integer heightProduct = 0;
    /** 卡扣项目 */
    Integer cardProjdect = 0;
     /** 卡扣产品 */
    Integer cardProduct = 0;
     /** 店长个人业绩 */
    BigDecimal storeMoney = new BigDecimal(0);
    /** 备注 */
    String remarks = "";


    public static void getDate(MonthDetails m, ServiceOrders serviceOrders, Staff user){
        m.setPeopleTotal(m.getPeopleTotal()+1);
        //如果是现金单 说明是到店付款的
        if (serviceOrders.getOrderType().equals("0")){
            m.setGoSotreNum(m.getGoSotreNum()+1);
        }
        m.setTotalMoney(m.getTotalMoney().add(serviceOrders.getTotalAmount()));
        m.setActualTotal(m.getActualTotal().add(serviceOrders.getCashAmount()).add(serviceOrders.getSavingsAmount()));
        List<ServiceProject> serviceProjects = serviceOrders.getProject();
        if (serviceOrders != null) {
            for (ServiceProject project : serviceProjects) {
                if (project.getCardId() != null && !project.getCardId().equals("")) {
                    m.setCardProduct(m.getCardProjdect()+1);
                }
            }
        }
        List<ServiceProduct> serviceProducts = serviceOrders.getProduct();
        if (serviceOrders != null) {
            for (ServiceProduct product : serviceProducts) {
                if (product.getCardId() != null && !product.getCardId().equals("")) {
                    m.setCardProduct(m.getCardProduct()+1);
                }
            }
        }
        if (user.getId().equals(serviceOrders.getOperatorId())){
            m.setStoreMoney(m.getStoreMoney().add(serviceOrders.getTotalAmount()));
        }
    }

    public static Map<String, Object> getTitle(ManagerOfTheMonthlyReport s, MonthDetails m){
        List<String> title = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        //同一全部返回数组
        List<Map<String, Object>> maps = new ArrayList<>();
        //全店业绩
        if(s.getShopPerformance()){
            title.add("cashPerformance");
            map.put("cashPerformance", m.getTotalMoney());
        }
        //全店客流
        if (s.getShopPassenger()){
            title.add("shopPassenger");
            map.put("shopPassenger", m.getPeopleTotal());
        }
        //卡扣产品
        if (s.getProduct()){
            title.add("product");
            map.put("product", m.getCardProduct());
        }
        //全店到店人数
        if (s.getFullStoreNumber()){
            title.add("fullStoreNumber");
            map.put("fullStoreNumber", m.getStoreMoney());
        }
        //全店实操
        if (s.getFullShopPractice()){
            title.add("fullShopPractice");
            map.put("fullShopPractice", m.getActualTotal());
        }
        //卡扣项目
        if (s.getBuckleProject()){
            title.add("buckleProject");
            map.put("buckleProject", m.getCardProjdect());
        }
        //高端项目
        if (s.getHighEndProject()){
            title.add("highEndProject");
            map.put("highEndProject", m.getHeightProduct());
        }
        //是否记录店长
        if (s.getRecordTheStoreManager()){
            title.add("recordTheStoreManager");
            map.put("recordTheStoreManager", m.getGoSotreNum());
        }
        //备注
        if (s.getRemarks()){
            title.add("remarks");
            map.put("remarks", m.getRemarks());
        }
        maps.add(map);
        result.put("title", title);
        result.put("data", maps);
        return result;
    }
}
