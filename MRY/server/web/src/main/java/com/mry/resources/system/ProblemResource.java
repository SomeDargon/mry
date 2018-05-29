package com.mry.resources.system;

import com.mry.entity.store.customer.ProblemDescription;
import com.mry.entity.store.customer.Solution;
import com.mry.json.StatusJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.ProblemService;
import com.mry.util.Constants;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/11/28.
 * 问题描述
 */
@Api(description="问题描述", value = "问题描述")
@Controller
@RequestMapping("/app/api/problem")
public class ProblemResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ProblemResource.class);

    @Resource
    private ProblemService problemService;

    /**
     * 新增描述
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ProblemDescription data) {
        int c =problemService.save(authToken, data);
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
     * 新增描述
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody ProblemDescription data) {
        int c =problemService.edit(authToken, data);
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
     * 查询所有的问题
     * @param name
     * @return
     */
    @RequestMapping(value = "/findProblemList", method = RequestMethod.GET)
    public @ResponseBody
    List<ProblemDescription> findProblemList(
          //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam("id") Long id,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return problemService.findProblemList(id);
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

        problemService.delete(authToken, id);
    }



    /**
     * 新增描述
     *
     * @param data
     */
    @RequestMapping(value = "/solution/save", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson saveSolution(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody Solution data) {
        int c =problemService.saveSolution(authToken, data);
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
     * 新增描述
     *
     * @param data
     */
    @RequestMapping(value = "/solution/edit", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson editSolution(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody Solution data) {
        int c =problemService.editSolution(authToken, data);
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
     * 查询所有的问题
     * @param name
     * @return
     */
    @RequestMapping(value = "/solution/findSolutionList", method = RequestMethod.GET)
    public @ResponseBody
    List<Solution> findSolutionList(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam("id") Long id,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return problemService.findSolutionList(id);
    }

    /**
     * 删除（只是变成不启用转台）
     * @param authToken
     * @param id
     */
    @RequestMapping(value = "Solution/delete", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteSolution(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken, //
            @RequestParam("id") Long id) {

        problemService.deleteSolution(authToken, id);
    }

}
