package com.mry.resources;

import com.mry.json.CityJson;
import com.mry.json.ProvinceForJson;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.*;
import com.mry.json.system.StoreCustomerJson;
import com.mry.json.system.StoreCustomerManagement;
import com.mry.service.store.StoreService;
import com.mry.util.Constants;
import com.mry.util.ExcelUitl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app/api/store")
public class StoreResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(StoreResource.class);

    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
        StatusJson save(
                    //@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody StoreJson data) {
        int c =storeService.save(data);
        StatusJson s = new StatusJson();
        if(c==1){
            s.setStatus(1);
            s.setMessage("保存成功");
        }else{
            s.setStatus(2);
            s.setMessage("保存失败");
        }
        return s;
    }


    /**
     * 注册门店
     *
     * @param data
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public  @ResponseBody
        StatusJson register(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody StoreJson data) {
        int c =storeService.register(data);
        StatusJson s = new StatusJson();
        if(c==1){
            s.setStatus(1);
            s.setMessage("保存成功");
        }else{
            s.setStatus(2);
            s.setMessage("保存失败");
        }
        return s;
    }

    /**
     * 检查门店名称是否重复
     *
     * @param
     */
    @RequestMapping(value = "/checkStoreName", method = RequestMethod.GET)
    public
    @ResponseBody
    storeNameJson checkName(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                               @RequestParam String storeName) {
        Boolean a =storeService.checkStoreName(storeName);
        storeNameJson c = new storeNameJson();
        c.setSuccess(a);
        return  c;
    }

    @RequestMapping("/provinces")
    public
    @ResponseBody
    List<ProvinceForJson> getAllProvinces() {
        return storeService.getAllProvinces();
    }

    @RequestMapping("/cities/province/{provinceid}")
    public
    @ResponseBody
    List<CityJson> getCitiesByProvince(
            @PathVariable("provinceid") Long provinceId) {
        return storeService.findCitiesByProvinceId(provinceId);
    }

    @RequestMapping("/cities")
    public
    @ResponseBody
    List<CityJson> getAllCities() {
        return storeService.findAllCities();
    }

    /**
     * 编辑门店
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody StoreJson data) {
        int c =storeService.edit(data);
        StatusJson s = new StatusJson();
        if(c==1){
            s.setStatus(1);
            s.setMessage("保存成功");
        }else{
            s.setStatus(2);
            s.setMessage("保存失败");
        }
        return s;
    }

    /**
     * 编辑门店客户管理
     *
     * @param data
     */
    @RequestMapping(value = "/editStoreCustomer", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editStoreCustomer(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody StoreCustomerManagement data) {
        int c =storeService.editStoreCustomer(data);
        StatusJson s = new StatusJson();
        if(c==1){
            s.setStatus(1);
            s.setMessage("保存成功");
        }else{
            s.setStatus(2);
            s.setMessage("保存失败");
        }
        return s;
    }

    /**
     * 查询客户信息
     * @return
     */
    @RequestMapping(value = "/findStoreById", method = RequestMethod.GET)
    public @ResponseBody StoreCustomerJson findStoreById(
            @RequestParam("id") Long id){
        return storeService.findStoreById(id);
    }


    /**
     * 查询所有没有审核或者审核没有通过的门店
     * @param name
     * @return
     */
    @RequestMapping(value = "/findStoreRegister", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<StoreListJson> findStoreRegister(
        //    @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "id" , required = false) Long id,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return storeService.findStoreRegister(name,id,page,pageSize);
    }

    /**
     * 根据电话号码查询门店
     * @param phoneNumber
     * @return
     */
    @RequestMapping(value = "/findAuditOfFailure", method = RequestMethod.GET)
    public @ResponseBody
        StoreListJson findAuditOfFailure(
            //    @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "phoneNumber" , required = true) String phoneNumber){
        return storeService.findAuditOfFailure(phoneNumber);
    }

    /**
     * 根据电话号码查询门店，生成验证码
     * @param phoneNumber
     * @return
     */
    @RequestMapping(value = "/getVerification ", method = RequestMethod.GET)
    public @ResponseBody
    StatusJson getVerification(
            //    @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "phoneNumber" , required = true) String phoneNumber){
        return storeService.getVerification(phoneNumber);
    }


    /**
     * 根据验证码和手机号码修改为随机密码
     * @param data
     * @return
     */
    @RequestMapping(value = "/updataByPhone", method = RequestMethod.POST)
    public @ResponseBody
    StatusJson updataByPhone(
            //    @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody VerificationJson data){
        return storeService.updataByPhone(data);
    }



    /**
     * 检查门店手机号码是否重复
     *
     * @param
     */
    @RequestMapping(value = "/checkStorePhone", method = RequestMethod.GET)
    public
    @ResponseBody
    storeNameJson checkStorePhone(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                            @RequestParam String phoneNumber) {
        Boolean a =storeService.checkStorePhone(phoneNumber);
        storeNameJson c = new storeNameJson();
        c.setSuccess(a);
        return  c;
    }

    /**
     * 编辑门店客户管理
     *
     */
    @RequestMapping(value = "/auditStoreCustomer", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson auditStoreCustomer( @RequestBody ResonOfAuditJson data) {
        int c =storeService.auditStoreCustomer(data);
        StatusJson s = new StatusJson();
        if(c==1){
            s.setStatus(1);
            s.setMessage("保存成功");
        }else{
            s.setStatus(2);
            s.setMessage("保存失败");
        }
        return s;
    }



    /**
     * 查询所有的门店
     * @param name
     * @return
     */
    @RequestMapping(value = "/findStoreList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<StoreListJson> findStoreList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "id" , required = false) Long id,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return storeService.findStoreList(authToken,name,id,page,pageSize);
    }





}
