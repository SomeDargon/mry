package com.mry.resources.store;

import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.ProjectJson;
import com.mry.json.store.RoomJson;
import com.mry.json.store.RoomListJson;
import com.mry.resources.BaseResource;
import com.mry.service.store.ProjectService;
import com.mry.service.store.RoomService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/11/1.
 * 房间管理
 */
@Controller
@RequestMapping("/app/api/room")
public class RoomResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(RoomResource.class);

    @Resource
    private RoomService roomService;

    /**
     * 新增房间
     *
     * @param data
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson save(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody RoomJson data) {
        int c =roomService.save(authToken, data);
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
     * 编辑房间
     *
     * @param data
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)

    public  @ResponseBody
    StatusJson edit(@RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
                    @RequestBody RoomJson data) {
        int c =roomService.edit(authToken, data);
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
     * 查询所有的房间
     * @param name
     * @return
     */
    @RequestMapping(value = "/findRoomList", method = RequestMethod.GET)
    public @ResponseBody
    ResultsWrapper<RoomListJson> findRoomList(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken,
            @RequestParam(value = "name" , required = false) String name,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        return roomService.findRoomList(authToken,name,page,pageSize);
    }

    @RequestMapping(value = "/findAllRoom", method = RequestMethod.GET)
    public @ResponseBody
    List<RoomListJson> findAllRoom(
            @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken){
        return roomService.findAllRoom(authToken);
    }

    /**
     * 根据Id查询房间
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody RoomListJson findById(
            @RequestParam(value = "id") Long id){
        return roomService.findById(id);
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

        roomService.delete(authToken, id);
    }
}
