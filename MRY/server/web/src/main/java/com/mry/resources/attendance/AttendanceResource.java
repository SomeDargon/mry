package com.mry.resources.attendance;

import com.mry.entity.store.attendance.AttendanceHandle;
import com.mry.entity.vo.ResultVO;
import com.mry.resources.BaseResource;
import com.mry.service.attendance.AttendanceService;
import com.mry.util.Constants;
import com.mry.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by somedragon on 2018/4/26.
 */
@Api(description="签到管理", value = "签到管理")
@Controller
@RequestMapping("/app/api/attendance")
public class AttendanceResource extends BaseResource {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceResource.class);

    @Resource
    private AttendanceService attendanceService;

    @ApiOperation(value = "签到")
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public ResultVO attendanceEdit(
            @RequestParam(required = true)Integer type, @RequestParam(required = true)Long userId,@RequestParam(required = false) String date){
        attendanceService.editAttendance(userId, type, date);
        return ResultVOUtil.success();
    }

//    @ApiOperation(value = "签到")
//    @RequestMapping(value = "/save", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultVO attendanceEdit(
//            @RequestParam(required = true)Integer type, @RequestParam(required = true)Long userId, @RequestParam(required = true)Long storeId
//            ,@RequestParam(required = false) String start, @RequestParam(required = false) String end){
////        attendanceService.editAttendance(userId, type, sta);
//        return ResultVOUtil.success();
//    }


}
