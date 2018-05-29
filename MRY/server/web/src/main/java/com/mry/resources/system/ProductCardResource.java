package com.mry.resources.system;

import com.mry.json.StatusJson;
import com.mry.json.system.*;
import com.mry.resources.BaseResource;
import com.mry.service.system.EntryService;
import com.mry.service.system.ProductCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2018/1/10.
 * 产品卡管理
 */
@Api(description="产品卡管理", value = "产品卡管理")
@Controller
@RequestMapping("/app/api/productCard")
public class ProductCardResource  extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ProductCardResource.class);

    @Resource
    private ProductCardService productCardService;


    /**
     * 新增
     *
     * @param data
     */
    @ApiOperation(value = "产品卡管理")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody ProductCardJson data) {
        int c =productCardService.save(data);
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
    @ApiOperation(value = " 编辑产品卡管理")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ProductCardJson data) {
        int c =productCardService.edit(data);
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
    @ApiOperation(value = " 查询所有产品卡管理")
    @RequestMapping(value = "/findproductCard", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductCardListJson> findproductCard(
            @RequestParam(value = "storeId") Long storeId,
            @RequestParam(value = "name" , required = false) String name){
        return productCardService.findproductCard(storeId,name);
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = " 删除 产品卡管理")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public
    @ResponseBody
    void delete(
            //    @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
            @RequestParam("id") Long id) {

        productCardService.delete(id);
    }
}
