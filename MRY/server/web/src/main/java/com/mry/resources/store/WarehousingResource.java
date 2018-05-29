package com.mry.resources.store;

import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.*;
import com.mry.resources.BaseResource;
import com.mry.service.store.WarehousingService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;

/**
 * Created by kaik on 2017/11/20.
 */
@Controller
@RequestMapping("/app/api/warehousing")
public class WarehousingResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(WarehousingResource.class);

    @Resource
    private WarehousingService warehousingService;

    /**
     * 新增入库商品
     * @param authToken
     * @param data
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody WarehousingJson data) {
        int c =warehousingService.save(authToken, data);
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
     * 编辑入库商品
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody WarehousingJson data) {
        int c =warehousingService.edit(authToken, data);
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
     * 查询所有的商品库存
     * @param name
     * @return
     */
    @RequestMapping(value = "/findWarehousingList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<WarehousingListJson> findWarehousingList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return warehousingService.findWarehousingList(authToken,name,page,pageSize);
    }


    /**
     * 查询所有的商品库存(盘点)
     * @param name
     * @return
     */
    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<WarehousingPdJson> findList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return warehousingService.findList(authToken,name,page,pageSize);
    }

    /**
     * 查询所有的商品库存(盘点)
     * @param name
     * @return
     */
    @RequestMapping(value = "/findAllList", method = RequestMethod.GET)
    public @ResponseBody
    List<WarehousingPdJson> findAllList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken){
        return warehousingService.findAllList(authToken);
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

        warehousingService.delete(authToken, id);
    }

    /**
     * 出库
     * @param authToken
     */
    @RequestMapping(value = "/warehousingOut", method = RequestMethod.GET)
    public
    @ResponseBody
    StatusJson WarehousingOut(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
            @RequestParam("name") String name,
            @RequestParam(value ="code", required = false) String code,
            @RequestParam("type") String type,
            @RequestParam("actualQuantity") String actualQuantity) {
        return warehousingService.WarehousingOut(authToken,name,code,type,actualQuantity);
    }

    /**
     * 查询所有出库的商品库存
     * @param name
     * @return
     */
    @RequestMapping(value = "/findWarehousinOutgList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<WarehousingOutJson> findWarehousinOutgList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "type" , required = false) String type,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return warehousingService.findWarehousinOutgList(authToken,name,type,page,pageSize);
    }


}
