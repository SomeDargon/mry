package com.mry.resources.store;

import com.mry.entity.dto.StaffDTO;
import com.mry.entity.user.StaffManyCustomer;
import com.mry.form.StaffManyCustomerFrom;
import com.mry.json.StatusJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.StaffManyCustomerService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by somedragon on 2018/4/17.
 */
@Controller
@RequestMapping("/app/api/staffManyCustomer")
@Api(description="用户指定技师，或者站长指定技术")
public class StaffManyCustomerResource  extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(StaffManyCustomerResource.class);
    @Resource
    private StaffManyCustomerService staffManyCustomerService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存用户", notes = "", response = StatusJson.class)
    @ResponseBody
    public StatusJson save(@RequestBody StaffManyCustomerFrom staffManyCustomerFrom){
        staffManyCustomerService.save(staffManyCustomerFrom);
        StatusJson s = new StatusJson(1, "保存成功");
        s.setStatus(1);
        s.setMessage("保存成功");
        return s;
    }

    @RequestMapping(value = "/findStoredId", method = RequestMethod.GET)
    @ApiOperation(value = "获取指定技师", notes = "", response = StaffDTO.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId",paramType = "query",value = "用户名", required = true, dataType = "Long"),
        @ApiImplicitParam(name = "storedId",paramType = "query", value = "店id", required = true, dataType = "Long"),
        @ApiImplicitParam(name = "type",paramType = "query", value = "0:表示用户指定 1:表示管理员指定", required = true, dataType = "Long")
    })
    @ResponseBody
    public StaffDTO findStoredId(@RequestParam Long userId, @RequestParam Long storedId, @RequestParam Long type){
        return staffManyCustomerService.findByStaff(userId, storedId, type.intValue());
    }

}
