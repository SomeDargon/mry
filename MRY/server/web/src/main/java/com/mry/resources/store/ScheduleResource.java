package com.mry.resources.store;

import com.mry.json.StatusJson;
import com.mry.json.store.ScheduleJson;
import com.mry.json.store.ScheduleListJson;
import com.mry.json.store.SchedulexxJson;
import com.mry.json.store.serviceOrder.ServiceOrderListJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.ScheduleService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/11/21.
 * 预约管理
 */
@Controller
@RequestMapping("/app/api/schedule")
public class ScheduleResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleResource.class);

    @Resource
    private ScheduleService scheduleService;


    /**
     * 新增预约
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ScheduleJson data) {
        int c =scheduleService.save(authToken, data);
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
     * 修改预约
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ScheduleJson data) {
        int c =scheduleService.edit(authToken, data);
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
     * 查询预约
     * @param scheduleDate
     * @return
     */
    @RequestMapping(value = "/findScheduleList", method = RequestMethod.GET)
    public @ResponseBody
    List<ScheduleListJson> findScheduleList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "scheduleDate" , required = false) String scheduleDate,
            @RequestParam(value = "scheduleStatus" , required = false) String scheduleStatus,
            @RequestParam(value = "id" , required = false) Long id){
        return scheduleService.findScheduleList(authToken,scheduleDate,scheduleStatus,id);
    }

    /**
     * 查询预约
     * @param
     * @return
     */
    @RequestMapping(value = "/findSchedule", method = RequestMethod.GET)
    public @ResponseBody
    SchedulexxJson findSchedule(
       //     @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
       //     @RequestParam(value = "scheduleDate" , required = false) String scheduleDate,
            @RequestParam(value = "id" , required = false) Long id){
        return scheduleService.findSchedule(id);
    }

    /**
     * 预约转服务单
     * @param
     * @return
     */
    @RequestMapping(value = "/toServiceOrder", method = RequestMethod.GET)
    public @ResponseBody
    ServiceOrderListJson toServiceOrder(
                 @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id" , required = false) Long id){
        return scheduleService.toServiceOrder(authToken,id);
    }


}
