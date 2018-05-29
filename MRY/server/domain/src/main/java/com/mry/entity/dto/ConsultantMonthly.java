//package com.mry.entity.dto;
//
//import com.mry.entity.store.serviceOrders.ServiceOrders;
//import com.mry.entity.store.serviceOrders.ServiceProduct;
//import com.mry.entity.store.serviceOrders.ServiceProject;
//import com.mry.entity.system.BeauticianMonthlyReport;
//import com.mry.entity.system.ConsultantMonthlyReport;
//import com.mry.entity.user.Staff;
//import lombok.Data;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by somedragon on 2018/5/29.
// */
//@Data
//public class ConsultantMonthly {
//    /** 到点人数 */
//    private Integer storeNumber;
//
//    /** 首次到店人数 */
//    private Integer firstStoreNumber;
//
//    /** 二次成交人数 */
//    private Integer twoTurnover;
//
//    /** 首次成交人数 */
//    private Integer firstTransactionNumber;
//
//    /** 实操总额 */
//    private BigDecimal totalActualExercise;
//
//    /** 客单价 */
//    private BigDecimal unitPrice;
//
//    /** 客流 */
//    Integer passengerNum = 0;
//
//    /** 个人业绩 */
//    BigDecimal personalPerformance = new BigDecimal(0);
//
//    /** 会员存储 */
//    BigDecimal memberStorageValue = new BigDecimal(0);
//
//    /** 售前 */
//    private String preSale;
//
//    /** 售后 */
//    private String aftermarket;
//
//    /** 美容现金*/
//    private BigDecimal beautyCash = new BigDecimal(0);
//
//    /** 美容实操 */
//    private BigDecimal beautyPractice = new BigDecimal(0);
//
//    /** 美发现金 */
//    private BigDecimal hairdressingCash = new BigDecimal(0);
//
//    /** 美发卡扣 */
//    private BigDecimal hairdressingSnap = new BigDecimal(0);
//
//    /** 瑜伽现金 */
//    private BigDecimal yogaCash = new BigDecimal(0);
//
//    /** 瑜伽卡扣 */
//    private BigDecimal yogaSnap = new BigDecimal(0);
//
//    /** 产品现金 */
//    private BigDecimal productCash = new BigDecimal(0);
//
//    /** 产品卡扣 */
//    private BigDecimal productSnap = new BigDecimal(0);
//
//    /** 欠款 */
//    private BigDecimal arrears = new BigDecimal(0);
//
//    //项目现金
//    private BigDecimal projectCash = new BigDecimal(0);
//    //项目卡扣
//    private BigDecimal projectSnap = new BigDecimal(0);
//
//
//
//
//    /**
//     * 根据BeauticianMonthly 中的条件生成数据
//     * @param b
//     * @param s
//     * @return
//     */
//    public static Map<String, Object> getData(ConsultantMonthly b, ConsultantMonthlyReport s){
//        Map<String, Object> map = new HashMap<>();
//        if (s.getStoreNumber()){
//            map.put("storeNumber", b.getStoreNumber());
//        }
//        if (s.getFirstStoreNumber()){
//            map.put("firstStoreNumber", b.getFirstStoreNumber());
//        }
//        if (s.getTwoTurnover()){
//            map.put("twoTurnover", b.getTwoTurnover());
//        }
//        if (s.getFirstTransactionNumber()){
//            map.put("firstTransactionNumber", b.getFirstTransactionNumber());
//        }
//        if (s.getTotalActualExercise()){
//            map.put("totalActualExercise", b.getTotalActualExercise());
//        }
//        if (s.getUnitPrice()){
//            map.put("unitPrice", b.getUnitPrice());
//        }
//        if (s.getPassenger()){
//            map.put("passenger", b.getPassengerNum());
//        }
//        if (s.getPersonalPerformance()){
//            map.put("personalPerformance", b.getPersonalPerformance());
//        }
//        if (s.getMemberStorageValue()){
//            map.put("memberStorageValue", b.getMemberStorageValue());
//        }
//        if (s.getPreSale()){
//            map.put("preSale", b.getPreSale());
//        }
//        if (s.getAftermarket()){
//            map.put("aftermarket", b.getAftermarket());
//        }
//        if (s.getBeautyCash()){
//            map.put("beautyCash", b.getBeautyCash());
//        }
//        if (s.getBeautyPractice()){
//            map.put("beautyPractice", b.getBeautyPractice());
//        }
//        if (s.getHairdressingCash()){
//            map.put("hairdressingCash", b.getHairdressingCash());
//        }
//        if (s.getHairdressingSnap()){
//            map.put("hairdressingSnap", b.getHairdressingSnap());
//        }
//        if (s.getYogaCash()){
//            map.put("yogaCash", b.getYogaCash());
//        }
//        if (s.getYogaSnap()){
//            map.put("yogaSnap", b.getYogaSnap());
//        }
//        if (s.getHairdressingSnap()){
//            map.put("hairdressingSnap", b.getHairdressingSnap());
//        }
//
//
//
//
//        if (s.getProductCash()){
//            map.put("productCash", b.getProductCash());
//        }
//        if (s.getProductSnap()){
//            map.put("productSnap", b.getProductSnap());
//        }
//        if (s.getProjectCash()){
//            map.put("projectCash", b.getProjectCash());
//        }
//        if (s.getProjectSnap()){
//            map.put("projectSnap", b.getProjectSnap());
//        }
//        return  map;
//    }
//
//    /**
//     * 根据BeauticianMonthly 中的条件生成头部
//     * @param s
//     * @return
//     */
//    public static List<String> getTitle(ConsultantMonthlyReport s){
//        List<String> title = new ArrayList<>();
//        if (s.getPassenger()){
//            title.add("passenger");
//        }
//        if (s.getStoragePerformance()){
//            title.add("storagePerformance");
//        }
//        if (s.getCashCourse()){
//            title.add("cashCourse");
//        }
//        if (s.getCardPerformance()){
//            title.add("cardPerformance");
//        }
//        if (s.getFacialPracticeAppoint()){
//            title.add("facialPracticeAppoint");
//        }
//        if (s.getFacialPracticeNonSpecifiedt()){
//            title.add("facialPracticeNonSpecifiedt");
//        }
//        if (s.getPhysicalExerciseAppoint()){
//            title.add("physicalExerciseAppoint");
//        }
//        if (s.getPhysicalExerciseNonSpecifiedt()){
//            title.add("physicalExerciseNonSpecifiedt");
//        }
//        if (s.getProductCash()){
//            title.add("productCash");
//        }
//        if (s.getProductSnap()){
//            title.add("productSnap");
//        }
//        if (s.getGiveHandToHand()){
//            title.add("giveHandToHand");
//        }
//        if (s.getIntroducePerformance()){
//            title.add("introducePerformance");
//        }
//        if (s.getProjectCash()){
//            title.add("projectCash");
//        }
//        if (s.getProjectSnap()){
//            title.add("projectSnap");
//        }
//        return title;
//    }
//
//    /**
//     *  算出计算技师月统计数据
//     * @param b
//     * @param service
//     * @param customer
//     */
//    public static void setData(BeauticianMonthly b, ServiceOrders service, Staff customer){
//        //消费单
//        if(service.getOrderType().equals("2") && service.getOperatorId().equals(customer.getId())) {
//            b.setPassengerNum(b.getPassengerNum()+1);
//            //存储业绩
//            if (service.getPaymentMethod().equals("0")) {
//                b.setStoragePerformance(b.getStoragePerformance().add(service.getCashAmount()))  ;
//            }
//            //现金疗程
//            if (service.getPaymentMethod().equals("1")) {
//                b.setCashCourse(b.getCashCourse().add(service.getCashAmount()));
//            }
//            //卡扣金额
//            b.setCardPerformance(b.getCardPerformance().add(service.getSavingsAmount()));
//            //面部指定 面部非指定 身体指定 身体非指定
//            if (service.getAppoint().equals("0")) {
//                b.setFacialPracticeAppoint(b.getFacialPracticeAppoint()+1);
//                b.setPhysicalExerciseAppoint(b.getPhysicalExerciseAppoint()+1);
//            } else {
//                b.setFacialPracticeNonSpecifiedt(b.getFacialPracticeNonSpecifiedt()+1);
//                b.setPhysicalExerciseNonSpecifiedt(b.getPhysicalExerciseNonSpecifiedt()+1);
//            }
//            List<ServiceProduct> serviceProducts = service.getProduct();
//            if (serviceProducts != null) {
//                for (ServiceProduct serviceProduct : serviceProducts) {
//                    //产品现金
//                    if (serviceProduct.getCardId() == null && serviceProduct.getCardId().equals("")) {
//                        b.setProductCash(b.getProjectCash().add(serviceProduct.getMoney()));
//                    }
//                    //产品卡扣
//                    if (serviceProduct.getCardId() != null && !serviceProduct.getCardId().equals("")) {
//                        b.setProductSnap(b.getProjectSnap().add(serviceProduct.getMoney()));
//                    }
//                }
//            }
//            List<ServiceProject> serviceProjects = service.getProject();
//            if (serviceProjects != null) {
//                for (ServiceProject serviceProject : serviceProjects) {
//                    //产品现金
//                    if (serviceProject.getCardId() == null && serviceProject.getCardId().equals("")) {
//                        b.setProjectCash(b.getProjectCash().add(serviceProject.getMoney()));
//                    }
//                    //产品卡扣
//                    if (serviceProject.getCardId() != null && !serviceProject.getCardId().equals("")) {
//                        b.setProjectSnap(b.getProjectSnap().add(serviceProject.getMoney()));
//                    }
//                }
//            }
//        }
//    }
//}
