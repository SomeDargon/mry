package com.mry.resources.system;

import com.mry.json.StatusJson;
import com.mry.json.system.MembershipJson;
import com.mry.json.system.MembersEnjoyListJson;
import com.mry.json.system.MembershipListJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.MembershipService;
import com.mry.util.Constants;
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
 * 会员卡管理
 */
@Api(description="会员卡管理", value = "会员卡管理")
@Controller
@RequestMapping("/app/api/membership")
public class MembershipCardResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(MembershipCardResource.class);

    @Resource
    private MembershipService membershipService;


    /**
     * 新增
     *
     * @param data
     */
    @ApiOperation(value = " 新增")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(
           // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody MembershipJson data) {
        int c =membershipService.save(data);
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
    @ApiOperation(value = " 编辑")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(//@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody MembershipJson data) {
        int c =membershipService.edit(data);
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
     * 查询所有会员卡
     * @param name
     * @return
     */
    @ApiOperation(value = "查询")
    @RequestMapping(value = "/findMembership", method = RequestMethod.GET)
    public @ResponseBody
    List<MembershipListJson> findMembership(
            @RequestParam(value = "storeId") Long storeId,
            @RequestParam(value = "name" , required = false) String name){
        return membershipService.findMembership(storeId,name);
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

        membershipService.delete(id);
    }
}
