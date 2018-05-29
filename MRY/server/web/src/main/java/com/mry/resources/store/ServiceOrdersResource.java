package com.mry.resources.store;

import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.serviceOrder.ServiceOrderJson;
import com.mry.json.store.serviceOrder.ServiceOrderListJson;
import com.mry.json.store.SettlementJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.ServiceOrdersService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/11/14.
 * 服务单
 */
@Controller
@RequestMapping("/app/api/service")
public class ServiceOrdersResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ServiceOrdersResource.class);

    @Resource
    private ServiceOrdersService serviceOrdersService;

    /**
     * 新增服务单
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ServiceOrderJson data) {
        int c =serviceOrdersService.save(authToken, data);
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
                    @RequestBody ServiceOrderJson data) {
        int c =serviceOrdersService.edit(authToken, data);
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
     * 查询所有的服务单
     * @param name
     * @return
     */
    @RequestMapping(value = "/findServiceOrder", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<ServiceOrderListJson> findServiceOrder(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "orderType" , required = false) String orderType,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return serviceOrdersService.findServiceOrder(authToken,orderType,name,page,pageSize);
    }


    /**
     * 根据Id查询服务单
     * @param id
     * @return
     */
        @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody ServiceOrderListJson findById(
            @RequestParam(value = "id") Long id){
        return serviceOrdersService.findById(id);
    }

    /**
     * 根据Id查询服务单
     * @param id
     * @return
     */
    @RequestMapping(value = "/findByCustomerId", method = RequestMethod.GET)
    public @ResponseBody
    List<ServiceOrderListJson> findByCustomerId(
            @RequestParam(value = "id") Long id){
        return serviceOrdersService.findByCustomerId(id);
    }

    /**
     * 结算
     *
     */
    @RequestMapping(value = "/settlement", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson settlement(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                          @RequestParam(value = "id") Long id) {
        StatusJson c =serviceOrdersService.settlement(authToken, id);

        return c;
    }


}
