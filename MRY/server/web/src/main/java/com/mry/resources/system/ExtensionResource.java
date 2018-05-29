package com.mry.resources.system;

import com.mry.json.StatusJson;
import com.mry.json.system.ExtensionJson;
import com.mry.json.system.ExtensionListJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.ExtensionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 * 拓客卡管理
 */
@Api(description="拓客卡管理", value = "拓客卡管理")
@Controller
@RequestMapping("/app/api/extension")
public class ExtensionResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ExtensionResource.class);

    @Resource
    private ExtensionService extensionService;



    /**
     * 新增
     *
     * @param data
     */
    @ApiOperation(value = " 编辑拓客卡")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(
            // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ExtensionJson data) {
        int c =extensionService.save(data);
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
    @ApiOperation(value = " 编辑拓客卡")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ExtensionJson data) {
        int c =extensionService.edit(data);
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
     * 查询所有拓客卡
     * @param name
     * @return
     */
    @ApiOperation(value = " 查询所有拓客卡")
    @RequestMapping(value = "/findExtension", method = RequestMethod.GET)
    public @ResponseBody
    List<ExtensionListJson> findExtension(
            @RequestParam(value = "storeId") Long storeId,
            @RequestParam(value = "name" , required = false) String name){
        return extensionService.findExtension(storeId,name);
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

        extensionService.delete(id);
    }
}
