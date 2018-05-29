package com.mry.resources.store;

import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.ProjectJson;
import com.mry.json.store.ProjectListJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.ProjectService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/11/1.
 */
@Controller
@RequestMapping("/app/api/project")
public class ProjectResource  extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ProjectResource.class);

    @Resource
    private ProjectService projectService;

    /**
     * 新增项目
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ProjectJson data) {
        int c =projectService.save(authToken, data);
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
     * 编辑项目
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ProjectJson data) {
        int c =projectService.edit(authToken, data);
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
     * 查询所有的项目
     * @param name
     * @return
     */
    @RequestMapping(value = "/findProjectList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<ProjectListJson> findProjectList(
          //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
          @RequestParam(value = "id" , required = true) Long id,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return projectService.findProjectList(id,name,page,pageSize);
    }

    /**
     * 查询所有的项目
     * @param
     * @return
     */
    @RequestMapping(value = "/findAllProject", method = RequestMethod.GET)
    public @ResponseBody
    List<ProjectListJson> findAllProjectt(@RequestParam(value = "id" , required = true) Long id){
           // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken
        return projectService.findAllProjectt(id);
    }

    /**
     * 根据Id查询项目
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody ProjectListJson findById(
            @RequestParam(value = "id") Long id){
        return projectService.findById(id);
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

        projectService.delete(authToken, id);
    }

}
