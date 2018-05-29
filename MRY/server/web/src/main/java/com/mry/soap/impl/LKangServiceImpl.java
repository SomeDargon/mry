package com.mry.soap.impl;

import com.mry.entity.config.ExternalDevice;
import com.mry.entity.user.Customer;
import com.mry.exception.BusinessException;
import com.mry.soap.LKangService;
import com.mry.soap.info.LKangInfoXml;
import com.mry.soap.result.LKExamCount;
import com.mry.soap.result.LKangResultXml;
import com.mry.util.JaxbUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/6/21 13:32
 */
@WebService(endpointInterface = "com.mry.soap.LKangService", serviceName = "lkangService")
public class LKangServiceImpl implements LKangService {
    private static final Logger logger = LoggerFactory.getLogger(LKangServiceImpl.class);
    //@Resource
    //private UserService userService;
//    @Resource
//    private ExternalDeviceService externalDeviceService;
    //@Resource
    //private CustomerServiceDetailService customerServiceDetailService;

    @Override
    public String funMain(String xmlString) {
        //返回消息
        LKangResultXml res = new LKangResultXml();
        try {
            LKangInfoXml xmlData = JaxbUtil.convertToJavaBean(xmlString, LKangInfoXml.class);
            if (xmlData.getFunctioncode() != 1007)
                logger.info("lkang device upload data---" + xmlString);
            xmlString = null;
      //      ExternalDevice device = externalDeviceService.findDeviceByMachineId(xmlData.getIcpcode());
//            if (device != null) {
//                switch (xmlData.getFunctioncode()) {
//                    case 2000://检查网络状态
//                        res = this.checkNetwork();
//                        break;
//                    case 2001://根据卡号查询用户信息
//                        res = this.getCustomerInfo(xmlData);
//                        break;
//                    case 2002://查询最近一次所有体检结果数据
//                        res = this.getCustomerLastHealthInfo(xmlData);
//                        break;
//                    case 2003://查询最近一个月的血压数据
//                        res = this.getBPByRecentOneMonth(xmlData);
//                        break;
//                    //case 2004://根据卡号查询健康促进信息
//                    //    break;
//                    case 1001://上传血压和脉搏数据
//                    case 1002://上传血氧数据
//                    case 1003://上传血糖数据
//                    case 1004://上传脂肪数据
//                    case 1005://上传身高、体重数据
//                        //case 1006://上传胎心率数据
//                    case 1007://上传心电数据
//                        //case 1008://上传调查报告结果
//                    case 1010://上传胆固醇
//                    case 1011://上传尿酸
//                    case 1012://上传腰臀比
//                        //case 1013://上传骨密度
//                        res = this.saveHealthInfo(xmlData);
//                        break;
//                    case 1009://注册
//                        res = this.register(xmlData, device);
//                        break;
//                    default:
//                        res.setErrCode(-1);
//                        res.setErrMsg("未知交易码");
//                        break;
//                }
//            } else {
//                res.setErrCode(-1);
//                res.setErrMsg("设备未找到");
//            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            res.setErrCode(1);
            if (e instanceof BusinessException) {
                if (((BusinessException) e).getErrorCode().getErrorCode() != 6032) {
                    //如果中文消息为空则返回英文消息
                    String msg = ((BusinessException) e).getErrorCode().getCnMessage();
                    if (StringUtils.isBlank(msg))
                        msg = ((BusinessException) e).getErrorCode().getMessage();
                    res.setErrCode(-1);
                    res.setErrMsg(msg);
                } else {
                    res.setErrCode(0);
                    res.setErrMsg("上传成功");
                }
            } else
                res.setErrMsg("服务器内部错误");
        }
        return JaxbUtil.convertToXml(res);
    }

    /**
     * 检查网络状态
     *
     * @return
     */
    private LKangResultXml checkNetwork() {
        LKangResultXml res = new LKangResultXml();
        res.setErrCode(0);
        res.setErrMsg("网络通畅");
        return res;
    }

    /**
     * 根据卡号查询用户信息
     *
     * @param xmlData
     * @return
     */
    private LKangResultXml getCustomerInfo(LKangInfoXml xmlData) {
        //这里cardNo可能是手机号或者身份证
        Customer customer = getCustomerByIdCardOrPhone(xmlData.getCardNo());

        //判断是否是刷卡
        int errCode = -1;
        if (StringUtils.isNotBlank(xmlData.getFullname())
                && StringUtils.isNotBlank(xmlData.getBirthday())
                && StringUtils.isNotBlank(xmlData.getGender())
                && StringUtils.isNotBlank(xmlData.getAddr()))
            errCode = 1;
        xmlData = null;

        //返回数据
        LKangResultXml res = new LKangResultXml();
        if (customer != null) {
            res.setErrCode(0);
            res.setErrMsg("查询成功");
            res.setName(customer.getRealName());
            //res.setSex("MALE".equals(customer.getGender()) ? "男" : "女");
          //  res.setBirthday(DatetimeUtil.formatDate(customer.getBirthday()));
            //res.setHeight(customer.getHeight() == null ? 0 : customer.getHeight());
            //res.setWeight(customer.getWeight() == null ? 0 : customer.getWeight());

            //获取用户测试次数
            List<LKExamCount> examCounts = new ArrayList<>();
           /* customerServiceDetailService.queryServiceCounts(customer.getId()).forEach(a -> {
                LKExamCount temp = new LKExamCount();
                temp.setType(a.getType());
                temp.setCount(a.getCount());
                examCounts.add(temp);
            });
            */
            res.setLkExamCounts(examCounts);
        } else {
            res.setErrCode(errCode);
            if (errCode == 1)
                res.setErrMsg("不存在该用户");
            else
                res.setErrMsg("输入的手机号或身份证不存在，请刷身份证注册。");
        }
        return res;
    }

    /**
     * 获取用户最近一次健康数据
     *
     * @param xmlData
     * @return
     */
    private LKangResultXml getCustomerLastHealthInfo(LKangInfoXml xmlData) throws IOException {
        //这里cardNo可能是手机号或者身份证
        Customer customer = getCustomerByIdCardOrPhone(xmlData.getCardNo());
        xmlData = null;
        //返回数据
        LKangResultXml res = new LKangResultXml();
        /*if (customer != null) {
            //健康数据
            HealthCheckInfoJson healthInfo = userService.getCustomerLastHealthInfo(customer.getId());
            if (healthInfo != null) {
                res.setErrCode(0);
                res.setErrMsg("查询成功");
                res.setHeight(customer.getHeight());
                res.setWeight(customer.getWeight());
                res.setSbp(healthInfo.getMorningSystolicPressure());
                res.setDbp(healthInfo.getMorningDiastolicPressure());
                res.setPulse(healthInfo.getPulseRate());
                res.setBo(healthInfo.getSpo());

                //血糖
                if (healthInfo.getFastBloodSugar() != null) {
                    res.setGlu(healthInfo.getFastBloodSugar());
                    res.setHoursAfterMeal(0);
                } else if (healthInfo.getRandomBloodSugar() != null) {
                    res.setGlu(healthInfo.getRandomBloodSugar());
                    res.setHoursAfterMeal(1);
                } else if (healthInfo.getPostPrandilaSugar() != null) {
                    res.setGlu(healthInfo.getPostPrandilaSugar());
                    res.setHoursAfterMeal(2);
                }

                res.setChol(healthInfo.getBloodFatChol());

                //尿酸
                res.setUa(healthInfo.getUrineAcid());
                if (res.getUa() != null)
                    res.setUa(res.getUa() / 1000);

                res.setHdl(healthInfo.getBloodFatHdl());
                res.setLdl(healthInfo.getBloodFatLdl());
                res.setTg(healthInfo.getBloodFatTg());
                res.setBmi(healthInfo.getBmi());
                res.setFat(healthInfo.getFatPercentage());
                res.setBmr(healthInfo.getBasalMetabolism());
                res.setWater(healthInfo.getWaterContent());
                res.setWaistline(healthInfo.getWaist());
                res.setHipline(healthInfo.getHipline());
                res.setWhr(healthInfo.getWhr());

                //心电
                if (StringUtils.isNotBlank(healthInfo.getEcgPdf()))
                    //程序绝对路径+文件相对路径=文件绝对路径，获取文件byte[],然后再转16进制字符串
                    res.setEcg(HexStringUtil.byteArrayToHexString(FileHelper.getBytes(Application.getFilePath().getAbsolutePath() + healthInfo.getEcgPdf())));
                if (StringUtils.isNotBlank(healthInfo.getEcgXml()))
                    res.setEcgxml(HexStringUtil.byteArrayToHexString(FileHelper.getBytes(Application.getFilePath().getAbsolutePath() + healthInfo.getEcgXml())));

                healthInfo = null;
            } else {
                res.setErrCode(-1);
                res.setErrMsg("查询失败");
            }
        } else {
            res.setErrCode(-1);
            res.setErrMsg("不存在该用户");
        }
        return res;*/
        return null;
    }

    /**
     * 获取最近一个月的血压数据
     *
     * @param xmlData
     * @return
     */
    private LKangResultXml getBPByRecentOneMonth(LKangInfoXml xmlData) {
        //这里cardNo可能是手机号或者身份证
        Customer customer = getCustomerByIdCardOrPhone(xmlData.getCardNo());
        xmlData = null;
        LKangResultXml res = new LKangResultXml();
        if (customer != null) {
            res.setErrCode(0);
            res.setErrMsg("查询成功");
            //res.setLKbloodPressures(userService.getBPByRecentOneMonth(customer.getId()));
        } else {
            res.setErrCode(-1);
            res.setErrMsg("不存在该用户");
        }
        return res;
    }

    /**
     * 保存健康数据
     *
     * @param xmlData
     * @return
     */
    private LKangResultXml saveHealthInfo(LKangInfoXml xmlData) throws IOException {
        //返回数据
        LKangResultXml res = new LKangResultXml();

        //这里cardNo可能是手机号或者身份证
        Customer customer = getCustomerByIdCardOrPhone(xmlData.getCardNo());

        if (customer != null) {
            //数据转换
            //HealthCheckInfoJson healthCheckInfoJson = new HealthCheckInfoJson();

            //测量时间
           /* healthCheckInfoJson.setCheckTime(xmlData.getCheckdate());
            healthCheckInfoJson.setMorningSystolicPressure(xmlData.getSbp());
            healthCheckInfoJson.setMorningDiastolicPressure(xmlData.getDbp());
            healthCheckInfoJson.setPulseRate(xmlData.getPulse());
            healthCheckInfoJson.setBloodFatChol(xmlData.getChol());
            healthCheckInfoJson.setBloodFatHdl(xmlData.getHdl());
            healthCheckInfoJson.setBloodFatLdl(xmlData.getLdl());
            healthCheckInfoJson.setBloodFatTg(xmlData.getTg());
            healthCheckInfoJson.setSpo(xmlData.getBo());
            healthCheckInfoJson.setBmi(xmlData.getBmi());
            healthCheckInfoJson.setFatPercentage(xmlData.getFat());
            healthCheckInfoJson.setBasalMetabolism(xmlData.getBmr());
            healthCheckInfoJson.setWaterContent(xmlData.getWater());
            healthCheckInfoJson.setWaist(xmlData.getWaistline());
            healthCheckInfoJson.setHipline(xmlData.getHipline());
            healthCheckInfoJson.setWhr(xmlData.getWhr());
            //尿酸
            if (xmlData.getUa() != null)
                healthCheckInfoJson.setUrineAcid(xmlData.getUa() * 1000);
            //血糖项目
            if (xmlData.getHoursAfterMeal() != null) {
                switch (xmlData.getHoursAfterMeal()) {
                    case 0:
                        healthCheckInfoJson.setFastBloodSugar(xmlData.getGlu());
                        break;
                    case 1:
                        healthCheckInfoJson.setRandomBloodSugar(xmlData.getGlu());
                        break;
                    case 2:
                        healthCheckInfoJson.setPostPrandilaSugar(xmlData.getGlu());
                        break;
                }
            }
            //心电图
            if (xmlData.getEcgpng() != null) {
                List<ImageBinary> tempImgs = new ArrayList<ImageBinary>();
                ImageBinary tempImg = new ImageBinary();
                tempImg.setBinary(java.util.Base64.getEncoder().encodeToString(HexStringUtil.hexStringToByteArray(xmlData.getEcgpng())));
                tempImgs.add(tempImg);

                healthCheckInfoJson.setEcg(tempImgs);
                healthCheckInfoJson.setEcgPdf(xmlData.getEcg());
                healthCheckInfoJson.setEcgXml(xmlData.getEcgxml());
            }
            //身高
            if (xmlData.getHeight() != null)
                customer.setHeight(xmlData.getHeight().intValue());
            //体重
            if (xmlData.getWeight() != null)
                customer.setWeight(xmlData.getWeight().intValue());

            xmlData = null;

            customerServiceDetailService.saveHealthCheckInfo(customer, healthCheckInfoJson);
            res.setErrCode(0);
            res.setErrMsg("上传成功");
        } else {
            res.setErrCode(-1);
            res.setErrMsg("不存在该用户");
        }
        return res;*/
        }
        return null;
    }

    /**
     * 注册
     *
     * @param xmlData
     * @param device
     * @return
     */
    private LKangResultXml register(LKangInfoXml xmlData, ExternalDevice device) {
        //数据转换
        /*RegisterCustomerJson entity = new RegisterCustomerJson();
        entity.setAccount(xmlData.getCardNo());
        entity.setPassword("a123456");
        entity.setRealName(xmlData.getFullname());
        entity.setPhoneNumber(xmlData.getPhone());
        entity.setIdCardNumber(xmlData.getCardNo());
        entity.setGender("男".equals(xmlData.getGender()) ? "MALE" : "FAMALE");
        entity.setAddress(xmlData.getAddr());
        entity.setCityId(xmlData.getCityId());
        entity.setBirthday(xmlData.getBirthday());
        //16进制字符串转base64编码字符串
        entity.setIcon(java.util.Base64.getEncoder().encodeToString(HexStringUtil.hexStringToByteArray(xmlData.getPhoto())));
        entity.setSafeQuestion("优医的网址是什么？");
        entity.setSafeAnswer("www.uyidoctor.com");

        xmlData = null;

        userService.registerAndPushMsg(entity, device);

        //返回数据
        LKangResultXml res = new LKangResultXml();
        res.setErrCode(0);
        res.setErrMsg("上传成功");
        res.setAccount(entity.getAccount());
        res.setPassword(entity.getPassword());

        return res;
    */
            return null;
            }

    /**
     * 获取用户
     *
     * @param number
     * @return
     */
    private Customer getCustomerByIdCardOrPhone(String number) {
        /*//先用身份证登录
        CustomerMembersEnjoy customer = userService.customerLoginByIdCard(number);
        //再用手机号登录
        if (customer == null)
            customer = userService.customerLoginByPhone(number);
        return customer;*/
            return null;
    }
}
