package com.mry.service;

import com.mry.entity.Role;
import com.mry.entity.dao.store.RoleDao;
import com.mry.entity.user.Staff;
import com.mry.json.ResultsWrapper;
import com.mry.json.store.RoleJson;
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
public class RoleService extends BaseService{
    @Resource
    private RoleDao roleDao;



    public int saveorUpdata(String authToken,Role data) {
        //Staff user = getStaffByAuthToken(authToken);
//        if (user.getRoleId() != 1l) {
//            throw new BusinessException(ErrorCode.INSUFFICIENT_AUTHORITY);
//        }
//            Role role = new Role();
//            role.setRoleName(data.getRoleName());
//            role.setOrder(data.getOrder());
//            role.setStoreId(user.getStoreId());
//            role.setStoreName(user.getStoreName());
        data.setEnable(true);
        if(data.getId() ==null) {
            roleDao.saveObject(data);
        }else{
     //       role.setId(data.getId());
            roleDao.updateObject(data);
        }

        return 1;
    }

    public ResultsWrapper<RoleJson> findRoleList(String authToken, String name, Integer page, Integer pageSize) {
   //     Staff user = getStaffByAuthToken(authToken);
        List<RoleJson> role = roleDao.findList(name,page,pageSize);
//      List<RoleJson> json = new ArrayList<RoleJson>();
//        if (role.size()>0) {
//            role.forEach(a -> json.add(new RoleJson(a)));
//        }
        Long count = roleDao.findListCount(name);

        ResultsWrapper<RoleJson> h = new ResultsWrapper<RoleJson>();
        h.setResults(role);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));
        return h;
    }


    public int delete(Long id) {
            return roleDao.delete(id);
    }


}
