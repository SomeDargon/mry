package com.mry.resources.store;

import com.mry.entity.store.customer.OwningCard;
import com.mry.entity.vo.CardVO;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.*;
import com.mry.resources.BaseResource;
import com.mry.service.store.CustomerService;
import com.mry.util.Constants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/10/31.
 */
@Controller
@RequestMapping("/app/api/customer")
public class CustomerResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    @Resource
    private CustomerService customerService;

    /**
     * 新增顾客
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody CustomerJson data) {
        int c =customerService.save(authToken, data);
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
     * 编辑顾客
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody CustomerJson data) {
        int c =customerService.edit(authToken, data);
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
     * 充值
     *
     * @param data
     */
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson recharge(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody RechargeJson data) {
        int c =customerService.recharge(authToken, data);
        StatusJson s = new StatusJson();
        if(c==1){
            s.setStatus(1);
            s.setMessage("充值成功");
        }else{
            s.setStatus(2);
            s.setMessage("充值失败");
        }
        return s;
    }

    /**
     * 查询所有的顾客
     * @param name
     * @return
     */
    @RequestMapping(value = "/findCustomerList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<CustomerListJson> findCustomerList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return customerService.findCustomerList(authToken,name,page,pageSize);
    }

    /**
     * 查询所有的顾客
     * @param
     * @return
     */
    @RequestMapping(value = "/findAllCustomer", method = RequestMethod.GET)
    public @ResponseBody
    List<CustomerListJson> findAllCustomer(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken){
        return customerService.findAllCustomer(authToken);
    }

    /**
     * 根据Id查询顾客
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody CustomerListJson findById(
            @RequestParam(value = "id") Long id){
        return customerService.findById(id);
    }

    /**
     * 开卡
     * @param authToken
     * @param data
     * @return
     */
    @RequestMapping(value = "/doCard", method = RequestMethod.POST)
    @ApiOperation(value = "开卡", notes = "", response = StatusJson.class)
    public @ResponseBody StatusJson doCard(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                                           @RequestBody OwningCardJson data){
        int c = customerService.doCard(authToken,data);
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

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    @ApiOperation(value = "添加新的卡", notes = "", response = StatusJson.class)
    public @ResponseBody StatusJson addCard(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                                           @RequestBody CardVO data){
        int c = customerService.addCard(authToken,data);
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
     * 根据Id查询顾客拥有的卡
     * @param id
     * @return
     */
    @RequestMapping(value = "/findOwningCardById", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id查询顾客拥有的卡")
    public @ResponseBody
    ResultsWrapper<OwningCardListJson> findOwningCardById(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "id") Long id){
        return customerService.findOwningCardById(id,page,pageSize);
    }

    /**
     * 根据用户id查询服务记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/findBillById", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<BillJson> findBillById(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "paymentMethod", required = false) String paymentMethod,
            @RequestParam(value = "id") Long id){
        return customerService.findBillById(id,paymentMethod,page,pageSize);
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

        customerService.delete(authToken, id);
    }

    /**
     * 查询所有的问题
     * @param
     * @return
     */
    @RequestMapping(value = "/findAllProblem", method = RequestMethod.GET)
    public @ResponseBody
    List<ProblemDescriptionJson> findAllProblem(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken
                                                 ){
        return customerService.findAllProblem();
    }

    /**
     * 新增测试
     *
     * @param data
     */
    @RequestMapping(value = "/problemSave", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson problemSave(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody MyProblemJson data) {
        int c =customerService.problemSave(authToken, data);
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
     * 选择方案
     *
     * @param data
     */
    @RequestMapping(value = "/problemBegin", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson problemBegin(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                           @RequestBody MyProblemJson data) {
        int c =customerService.problemBegin(authToken, data);
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
     * 完成治疗
     *
     * @param data
     */
    @RequestMapping(value = "/completionPlan", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson completionPlan(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                            @RequestBody MyProblemJson data) {
        int c =customerService.completionPlan(authToken, data);
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
     * 生成方案根据id
     * @param
     * @return
     */
    @RequestMapping(value = "/findPlan", method = RequestMethod.GET)
    public @ResponseBody PlanJson findPlan(
            @RequestParam("type") String type,
            @RequestParam("id") Long id){
        return customerService.findPlan(type,id);
    }


    /**
     * 查询所有的问题
     * @param
     * @return
     */
    @RequestMapping(value = "/findMyProblem", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<MyProblemCheckJson> findMyProblem(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam("id") Long id){
        return customerService.findMyProblem(authToken,id,page,pageSize);
    }



}
