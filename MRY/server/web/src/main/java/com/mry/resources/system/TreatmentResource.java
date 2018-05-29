package com.mry.resources.system;

import com.mry.json.StatusJson;
import com.mry.json.system.TreatmentJson;
import com.mry.json.system.TreatmentJsonListJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.TreatmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2018/1/7.
 * 疗程组合卡管理
 */
@Controller
@RequestMapping("/app/api/treatment")
@Api(description="疗程组合卡管理", value = "疗程组合卡管理")//添加注释
public class TreatmentResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(TreatmentResource.class);

    @Resource
    private TreatmentService treatmentService;


    /**
     * 新增
     *
     * @param data
     */
    @ApiOperation(value = "新增疗程卡")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody TreatmentJson data) {
        int c =treatmentService.save(data);
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
    @ApiOperation(value = "编辑")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody TreatmentJson data) {
        int c =treatmentService.edit(data);
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
    @ApiOperation(value = "查询所有疗程卡")
    @RequestMapping(value = "/findTreatment", method = RequestMethod.GET)
    public @ResponseBody
    List<TreatmentJsonListJson> findTreatment(
            @RequestParam(value = "storeId") Long storeId,
            @RequestParam(value = "name" , required = false) String name){
        return treatmentService.findTreatment(storeId,name);
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
            //    @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
            @RequestParam("id") Long id) {

        treatmentService.delete(id);
    }
}
