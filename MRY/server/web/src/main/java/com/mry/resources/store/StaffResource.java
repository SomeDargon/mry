package com.mry.resources.store;

import com.mry.entity.user.Staff;
import com.mry.exception.BusinessException;
import com.mry.json.LoginResponseJson;
import com.mry.json.LoginUserJson;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.QuitJson;
import com.mry.json.store.StaffJson;
import com.mry.json.store.StaffListJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.StaffService;
import com.mry.servlet.validation.MaxLoginTryValidation;
import com.mry.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/10/27.
 * 员工管理
 */
@Controller
@RequestMapping("/app/api/user")
@Api(description = "员工管理")
public class StaffResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(StaffResource.class);

    @Resource
    private StaffService staffService;
    /**
     * 新增员工
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody StaffJson data) {
        int c =staffService.save(authToken, data);
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
     * 新增员工
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody StaffJson data) {
        int c =staffService.edit(authToken, data);
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
     * 员工修改密码
     *
     * @param password
     */
    @RequestMapping(value = "/editPassword", method = RequestMethod.GET)

    public  @ResponseBody
    StatusJson editPassword(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestParam String password) {
        int c =staffService.editPassword(authToken, password);
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
     * 查询所有的员工
     * @param name
     * @return
     */
    @RequestMapping(value = "/findUserList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<StaffListJson> findUserList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return staffService.findUserList(authToken,name,page,pageSize);
    }

    /**
     * 查询所有的员工
     * @return
     */
    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public @ResponseBody
    List<StaffListJson> findAllUser(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken){
        return staffService.findAllUser(authToken);
    }

    /**
     * 根据Id查询员工
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody StaffListJson findById(
            @RequestParam(value = "id") Long id){
        return staffService.findById(id);
    }

    /**
     * 删除（只是变成不启用转台）
     * @param authToken
     * @param id
     */
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public
//    @ResponseBody
//    void delete(
//            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
//            @RequestParam("id") Long id) {
//
//        staffService.delete(authToken, id);
//    }


    /**
     * 查询所有的离职员工
     * @param name
     * @return
     */
    @RequestMapping(value = "/findQuitList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<StaffListJson> findQuitList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return staffService.findQuitList(authToken,name,page,pageSize);
    }

    /**
     * 离职（只是变成不启用转台）
     * @param authToken
     */
    @RequestMapping(value = "/quit", method = RequestMethod.POST)
    public
    @ResponseBody
    StatusJson quit(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
            @RequestBody QuitJson data) {
        int c =staffService.quit(data);
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


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    LoginResponseJson login(HttpServletRequest request,
                            @RequestBody final LoginUserJson user) {
        logger.info("CustomerMembersEnjoy  " + user.getAccount() + " login...");

        try{
            LoginResponseJson result = staffService.login(user,request);

            request.getSession().setAttribute(MaxLoginTryValidation.QUEUE,null);
            return result;
        }catch(BusinessException be){
            ArrayDeque queue = (ArrayDeque)request.getSession().getAttribute(MaxLoginTryValidation.QUEUE);
            if(queue==null)
            {
                queue = new ArrayDeque();
                queue.addLast(new Date());
            }
            if(queue.size()==5) {
                Date first=(Date) queue.peekFirst();
                Date last=(Date)queue.peekLast();
                if(staffService.getErrorTime(first,last)<=10) {
                    request.getSession().setAttribute(MaxLoginTryValidation.RESTRICT, true);
                    queue.clear();
                }else{
                    queue.pollFirst();
                    queue.addLast(new Date());
                }
            }else{
                queue.addLast(new Date());
            }
            request.getSession().setAttribute(MaxLoginTryValidation.QUEUE,queue);
            throw be;
        }
    }

    /**
     *
     * @param authToken
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public
    void logout(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken) {
        staffService.logout(authToken);
    }

    @ApiOperation(value = "根据规则查询员工", notes = "", response = StatusJson.class)
    @RequestMapping(value = "/findStaff", method = RequestMethod.GET)
    public @ResponseBody
    List<StaffListJson> findStaff(
            @RequestParam Long storeId, @RequestParam Long id,
            @RequestParam Long staffId
    ){
        return staffService.findStaff(storeId, id, staffId);
    }


    @ApiOperation(value = "工资结算", notes = "", response = StatusJson.class)
    @RequestMapping(value = "/staffMoney", method = RequestMethod.GET)
    public @ResponseBody
    List<StaffListJson> staffMoney(
            @RequestParam Long storeId, @RequestParam Long id,
            @RequestParam Long staffId
    ){
        return staffService.findStaff(storeId, id, staffId);
    }
}
