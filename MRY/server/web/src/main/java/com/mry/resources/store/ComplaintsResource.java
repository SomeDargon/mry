package com.mry.resources.store;

import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.ComplaintsJson;
import com.mry.json.store.ComplaintsListJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.ComplaintsService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by kaik on 2017/11/3.
 * 投诉管理
 */
@Controller
@RequestMapping("/app/api/complaints")
public class ComplaintsResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ComplaintsResource.class);

    @Resource
    private ComplaintsService complaintsService;

    /**
     * 新增
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ComplaintsJson data) {
        int c =complaintsService.save(authToken, data);
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
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ComplaintsJson data) {
        int c =complaintsService.edit(authToken, data);
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
     * 处理
     *
     * @param data
     */
    @RequestMapping(value = "/handle", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson handle(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ComplaintsJson data) {
        int c =complaintsService.handle(authToken, data);
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
     * 查询所有的
     * @param name
     * @return
     */
    @RequestMapping(value = "/findComplaintsList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<ComplaintsListJson> findComplaintsList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return complaintsService.findComplaintsList(authToken,name,page,pageSize);
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody ComplaintsListJson findById(
            @RequestParam(value = "id") Long id){
        return complaintsService.findById(id);
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

        complaintsService.delete(authToken, id);
    }
}
