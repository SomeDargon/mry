package com.mry.resources.system;

import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.StoreJson;
import com.mry.json.system.PostListJson;
import com.mry.json.system.PostManagementJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.PostService;
import com.mry.util.Constants;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by kaik on 2017/12/25.
 */
@Api(description="岗位管理", value = "岗位管理")
@Controller
@RequestMapping("/app/api/post")
public class PostResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(PostResource.class);

    @Resource
    private PostService postService;

    /**
     * 新增
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody PostManagementJson data) {
        int c =postService.save(authToken,data);
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
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestBody PostManagementJson data) {
        int c =postService.edit(authToken,data);
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
     * 查询所有的职位
     * @param name
     * @return
     */
    @RequestMapping(value = "/findPostList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<PostListJson> findPostList(
         //   @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "id" , required = false ) Long id,//门店id
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return postService.findPostList(id,name,page,pageSize);
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

        postService.delete(authToken, id);
    }



}
