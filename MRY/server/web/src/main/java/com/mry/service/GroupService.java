package com.mry.service;


import com.mry.entity.Grouping;
import com.mry.entity.dao.store.GroupDao;
import com.mry.entity.dao.store.StaffDao;
import com.mry.entity.user.Staff;
import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.json.ResultsWrapper;
import com.mry.json.store.GroupJson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/10/27.
 */
@Service
@Transactional
public class GroupService extends BaseService{

    @Resource
    private GroupDao groupDao;
    @Resource
    private StaffDao staffDao;

    public int saveorUpdata(String authToken, GroupJson data) {

        Staff user = getStaffByAuthToken(authToken);
        Staff staff =staffDao.findById(data.getUserId());
        Grouping group = new Grouping();
        group.setGroupName(data.getGroupName());
        group.setSort(data.getSort());
        group.setStoreId(user.getStoreId());
        group.setStoreName(user.getStoreName());
        group.setUserId(data.getUserId());
        group.setUserName(staff.getRealName());
        group.setEnable(true);
        groupDao.updateObject(group);
        return 1;
    }

    public int edit(String authToken, GroupJson data) {
        Staff staff =staffDao.findById(data.getUserId());
        Grouping group = groupDao.findById(data.getId());
        group.setGroupName(data.getGroupName());
        group.setSort(data.getSort());
        group.setUserId(data.getUserId());
        group.setUserName(staff.getRealName());
        group.setEnable(true);
        return 1;
    }

    public ResultsWrapper<GroupJson> findGroupList(String authToken, String name, Integer page, Integer pageSize) {
        Staff user = getStaffByAuthToken(authToken);
        List<GroupJson> role = groupDao.findList(user.getStoreId(),name,page,pageSize);
     //   List<GroupJson> json = new ArrayList<GroupJson>();
        Long count = groupDao.findListCount(user.getStoreId(),name);

        ResultsWrapper<GroupJson> h = new ResultsWrapper<GroupJson>();
        h.setResults(role);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));
        return h;
    }

    public int delete(Long id) {
        return groupDao.delete(id);
    }


}
