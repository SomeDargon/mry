package com.mry.resources.system;

import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.system.CardJson;
import com.mry.json.system.CardListJson;
import com.mry.resources.BaseResource;
import com.mry.service.system.CardService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by kaik on 2017/11/29.
 * 卡类管理
 */
@Controller
@RequestMapping("/app/api/card")
public class CardResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(CardResource.class);

    @Resource
    private CardService cardService;

    /**
     * 新增卡
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody CardJson data) {
        int c =cardService.save(authToken, data);
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
     * 编辑卡
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody CardJson data) {
        int c =cardService.edit(authToken, data);
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
     * 查询所有的卡
     * @param name
     * @return
     */
    @RequestMapping(value = "/findCardList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<CardListJson> findCardList(
            //  @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return cardService.findCardList(name,page,pageSize);
    }

    /**
     * 根据Id查询卡详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody CardListJson findById(
            @RequestParam(value = "id") Long id){
        return cardService.findById(id);
    }
}
