package com.mry.resources.system;

import com.mry.json.StatusJson;
import com.mry.json.system.EntryJson;
import com.mry.json.system.EntryListJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.EntryService;
import com.mry.util.Constants;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/12/28.
 *条目信息
 */
@Api(description="条目信息管理", value = "条目信息管理")
@Controller
@RequestMapping("/app/api/entry")
public class EntryInformationResource  extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(EntryInformationResource.class);

    @Resource
    private EntryService entryService;


    /**
     * 新增
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(
         //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody EntryJson data) {
        int c =entryService.save(data);
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
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody EntryJson data) {
        int c =entryService.edit(data);
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
    @RequestMapping(value = "/findEntry", method = RequestMethod.GET)
    public @ResponseBody
    List<EntryListJson> findEntry(
            @RequestParam(value = "id" , required = false) Long id,
            @RequestParam(value = "name" , required = false) String name){
        return entryService.findEntry(id,name);
    }

    /**
     * 删除（只是变成不启用转台）
     * @param authToken
     * @param id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public
    @ResponseBody
    void delete(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
            @RequestParam("id") Long id) {
        entryService.delete(id);
    }

}
