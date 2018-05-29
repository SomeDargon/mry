package com.mry.resources.store;

import com.mry.entity.system.*;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.BeauticianJson;
import com.mry.json.store.DailyListJson;
import com.mry.json.store.DaySumJson;
import com.mry.json.store.RoomJson;
import com.mry.json.system.ActivityJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.ReportService;
import com.mry.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by kaik on 2017/11/30.
 * 报表
 */
@Api(description="报表管理", value = "报表管理")
@Controller
@RequestMapping("/app/api/report")
public class ReportResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ReportResource.class);

    @Resource
    private ReportService reportService;

    /**
     * 新增单店日报设计
     *
     * @param data
     */
    @ApiOperation(value = "新增单店日报设计")
    @RequestMapping(value = "/saveOrUpateDailyStoreDesign", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson saveDailyStoreDesign(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody DailyStoreDesign data) {
        int c =reportService.saveDailyStoreDesign(data);
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
     * 查询单店日报设计
     * @param
     * @return
     */
    @ApiOperation(value = "查新单店日报设计")
    @RequestMapping(value = "/findDailyStoreDesign", method = RequestMethod.GET)
    public @ResponseBody
    DailyStoreDesign findDailyStoreDesign(
           // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id){
        return reportService.findDailyStoreDesign(id);
    }

    /**
     * 新增单店月报设计
     *
     * @param data
     */
    @ApiOperation(value = "新增单店月报设计")
    @RequestMapping(value = "/saveOrUpateShopMonthlyReport", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson saveShopMonthlyReport(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ShopMonthlyReport data) {
        int c =reportService.saveShopMonthlyReport(data);
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
     * 单店月报设计
     * @param
     * @return
     */
    @ApiOperation(value = "查询单店月报设计")
    @RequestMapping(value = "/findShopMonthlyReport", method = RequestMethod.GET)
    public @ResponseBody
    ShopMonthlyReport findShopMonthlyReport(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id){
        return reportService.findShopMonthlyReport(id);
    }

    /**
     * 新增顾问月报表
     *
     * @param data
     */
    @ApiOperation(value = "新增顾问月报表")
    @RequestMapping(value = "/saveOrUpateConsultantMonthlyReport", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson saveConsultantMonthlyReport(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ConsultantMonthlyReport data) {
        int c =reportService.saveConsultantMonthlyReport(data);
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
     * 顾问月报表
     * @param
     * @return
     */
    @ApiOperation(value = "查询顾问月报表")
    @RequestMapping(value = "/findConsultantMonthlyReport", method = RequestMethod.GET)
    public @ResponseBody
    ConsultantMonthlyReport findConsultantMonthlyReport(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id){
        return reportService.findConsultantMonthlyReport(id);
    }

    /**
     * 新增技师月报表
     *
     * @param data
     */
    @ApiOperation(value = "新增技师月报表")
    @RequestMapping(value = "/saveOrUpateBeauticianMonthlyReport", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson saveBeauticianMonthlyReport(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody BeauticianMonthlyReport data) {
        int c =reportService.saveBeauticianMonthlyReport(data);
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
     * 美容师月报表
     * @param
     * @return
     */
    @ApiOperation(value = "查询技师月报表")
    @RequestMapping(value = "/findBeauticianMonthlyReport", method = RequestMethod.GET)
    public @ResponseBody
    BeauticianMonthlyReport findBeauticianMonthlyReport(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id){
        return reportService.findBeauticianMonthlyReport(id);
    }

    /**
     * 新增美发技师月报表
     *
     * @param data
     */
    @ApiOperation(value = "新增美发技师月报表")
    @RequestMapping(value = "/saveOrUpateHairTechnicianMonthlyReport", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson saveHairTechnicianMonthlyReport(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody HairTechnicianMonthlyReport data) {
        int c =reportService.saveHairTechnicianMonthlyReport(data);
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
     * 美发技师月报表
     * @param
     * @return
     */
    @ApiOperation(value = "查询美发技师月报表")
    @RequestMapping(value = "/findHairTechnicianMonthlyReport", method = RequestMethod.GET)
    public @ResponseBody
    HairTechnicianMonthlyReport findHairTechnicianMonthlyReport(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id){
        return reportService.findHairTechnicianMonthlyReport(id);
    }

    /**
     * 新增店长月报表
     *
     * @param data
     */
    @ApiOperation(value = "新增店长月报表")
    @RequestMapping(value = "/saveOrUpateManagerOfTheMonthlyReport", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson saveManagerOfTheMonthlyReport(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ManagerOfTheMonthlyReport data) {
        int c =reportService.saveManagerOfTheMonthlyReport(data);
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
     * 店长月报表
     * @param
     * @return
     */
    @ApiOperation(value = "查询店长月报表")
    @RequestMapping(value = "/findManagerOfTheMonthlyReport", method = RequestMethod.GET)
    public @ResponseBody
    ManagerOfTheMonthlyReport findManagerOfTheMonthlyReport(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id){
        return reportService.findManagerOfTheMonthlyReport(id);
    }

    /**
     * 新增详细店日报
     *
     * @param data
     */
    @ApiOperation(value = "新增详细店日报")
    @RequestMapping(value = "/saveOrUpateShopDailyDetails", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson saveShopDailyDetails(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ShopDailyDetails data) {
        int c = reportService.saveShopDailyDetails(data);
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
     * 详细店日报
     * @param
     * @return
     */
    @ApiOperation(value = "查询详细店日报")
    @RequestMapping(value = "/findShopDailyDetails", method = RequestMethod.GET)
    public @ResponseBody
    ShopDailyDetails findShopDailyDetails(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id){
        return reportService.findShopDailyDetails(id);
    }



    /**
     * 查询日报表
     * @param
     * @return
     */
    @RequestMapping(value = "/findDayList", method = RequestMethod.GET)
    public @ResponseBody
    List<DailyListJson> findDayList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "reportTime", required = false) String reportTime){
        return reportService.findDayList(authToken,reportTime);
    }

    /**
     * 查询日报总数据表统计
     * @param
     * @return
     */
    @RequestMapping(value = "/findDaySum", method = RequestMethod.GET)
    public @ResponseBody DaySumJson findDaySum(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "reportTime", required = false) String reportTime){
        return reportService.findDaySum(authToken,reportTime);
    }

    /**
     * 查询月报表统计
     * @param
     * @return
     */
    @RequestMapping(value = "/findMouthList", method = RequestMethod.GET)
    public @ResponseBody
    List<DaySumJson> findMouthList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "reportTime", required = false) String reportTime){
        return reportService.findMouthList(authToken,reportTime);
    }

    /**
     * 查询月报总数据表统计查询月报表统计
     * @param
     * @return
     */
    @RequestMapping(value = "/findMouthSum", method = RequestMethod.GET)
    public @ResponseBody DaySumJson findMouthSum(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "reportTime", required = false) String reportTime){
        return reportService.findMouthSum(authToken,reportTime);
    }

    /**
     * 查询美容师月报表统计
     * @param
     * @return
     */
    @RequestMapping(value = "/findBeauticianDaySum", method = RequestMethod.GET)
    public @ResponseBody
    List<BeauticianJson> findBeauticianDaySum(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "reportTime", required = false) String reportTime){
        return reportService.findBeauticianDaySum(authToken,id,reportTime);
    }


    /**
     * 店日报 内容详情
     * @param
     * @return
     */
    @ApiOperation(value = "店日报 内容详情")
    @RequestMapping(value = "/findDailyDetails", method = RequestMethod.GET)
    public @ResponseBody
    Map<Object, Object> findDailyDetails(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam String date
    ){
        return reportService.findDailyDetails( authToken, date);
    }


    /**
     * 店月报 内容详情
     * @param
     * @return
     */
    @ApiOperation(value = "店月报 内容详情")
    @RequestMapping(value = "/findMonthDetails", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findMonthDetails(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam String date
    ){
        return reportService.findMonthDetails( authToken, date);
    }


    /**
     * 技师报 内容详情
     * @param
     * @return
     */
    @ApiOperation(value = "技师报 内容详情")
    @RequestMapping(value = "/findStoreMonthDetails", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> findStoreMonthDetails(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam String date
    ){
        return reportService.findBeauticianMonthlyDetails( authToken, date);
    }
}
