package com.mry.service.store;

import com.mry.entity.dao.store.RoomDao;
import com.mry.entity.store.RoomManagement;
import com.mry.entity.user.Staff;
import com.mry.json.ResultsWrapper;
import com.mry.json.store.RoomJson;
import com.mry.json.store.RoomListJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/11/1.
 */
@Service
@Transactional
public class RoomService  extends BaseService {

    @Resource
    public RoomDao roomDao;

    public int save(String authToken, RoomJson data) {
        Staff user = getStaffByAuthToken(authToken);
        RoomManagement r = new RoomManagement();
        r.setStoreId(user.getStoreId());
        r.setStoreName(user.getStoreName());
        r.setRoomName(data.getRoomName());
        r.setRoomNumber(data.getRoomNumber());
        r.setRoomStatus("0");
        r.setEnable(true);
        roomDao.saveObject(r);
        return 1;
    }

    public int edit(String authToken, RoomJson data) {
        Staff user = getStaffByAuthToken(authToken);
        RoomManagement r = roomDao.findById(data.getId());
//        r.setStoreId(user.getStoreId());
//        r.setStoreName(user.getStoreName());
        r.setRoomName(data.getRoomName());
        r.setRoomNumber(data.getRoomNumber());
        r.setRoomStatus(data.getRoomStatus());
        r.setEnable(true);
        roomDao.updateObject(r);
        return 1;
    }

    public ResultsWrapper<RoomListJson> findRoomList(String authToken, String name, Integer page, Integer pageSize) {
        Staff user = getStaffByAuthToken(authToken);
        List<RoomManagement> users = roomDao.findList(user.getStoreId(),name,page,pageSize);
        List<RoomListJson> json = new ArrayList<RoomListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new RoomListJson(a)));
        }
        Long count = roomDao.findListCount(user.getStoreId(),name);

        ResultsWrapper<RoomListJson> h = new ResultsWrapper<RoomListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public RoomListJson findById(Long id) {
        RoomManagement p = roomDao.findById(id);
        RoomListJson json = new RoomListJson(p);
        return json;
    }

    public int delete(String authToken, Long id) {
        return roomDao.delete(id);
    }

    public List<RoomListJson> findAllRoom(String authToken) {
        Staff user = getStaffByAuthToken(authToken);
        List<RoomManagement> users = roomDao.findAllRoom(user.getStoreId());
        List<RoomListJson> json = new ArrayList<RoomListJson>();
        if (users.size()>0) {
            users.forEach(a ->json.add(new RoomListJson(a)));
        }
        return json;
    }
}
