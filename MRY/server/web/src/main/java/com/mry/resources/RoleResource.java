package com.mry.resources;

import com.mry.entity.Role;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.RoleJson;
import com.mry.resources.store.StaffResource;
import com.mry.service.RoleService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by kaik on 2017/10/27.
 */
@Controller
@RequestMapping("/app/api/role")
public class RoleResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(RoleResource.class);

    @Resource
    private RoleService roleService;

    /**
     * 新增与编辑小组
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody Role data) {
        int c =roleService.saveorUpdata(authToken, data);
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
    @RequestMapping(value = "/findRoleList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<RoleJson> findRoleList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return roleService.findRoleList(authToken,name,page,pageSize);
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
        roleService.delete(id);
    }
}
