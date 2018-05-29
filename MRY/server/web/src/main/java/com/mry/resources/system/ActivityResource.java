package com.mry.resources.system;

import com.mry.json.StatusJson;
import com.mry.json.system.ActivityJson;
import com.mry.json.system.activity.ActivityListJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.ActivityService;
import com.mry.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2018/1/11.
 */
@Api(description="活动卡管理", value = "活动卡管理")
@Controller
@RequestMapping("/app/api/activity")
public class ActivityResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ActivityResource.class);

    @Resource
    private ActivityService activityService;


    /**
     * 新增活动卡管理
     *
     * @param data
     */
    @ApiOperation(value = "保存活动卡管理")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ActivityJson data) {
        int c =activityService.save(data);
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
     * 编辑
     *
     * @param data
     */
    @ApiOperation(value = " 编辑活动卡管理")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ActivityJson data) {
        int c =activityService.edit(data);
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
     * 查询所有
     * @param name
     * @return
     */
    @ApiOperation(value = " 查询所有活动卡管理")
    @RequestMapping(value = "/findactivity", method = RequestMethod.GET)
    public @ResponseBody
    List<ActivityListJson> findactivity(
            @RequestParam(value = "storeId" , required = false) Long storeId,
            @RequestParam(value = "name" , required = false) String name){
        return activityService.findactivity(storeId,name);
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = " 删除")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public
    @ResponseBody
    void delete(
           // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
            @RequestParam("id") Long id) {
        activityService.delete(id);
    }
}
