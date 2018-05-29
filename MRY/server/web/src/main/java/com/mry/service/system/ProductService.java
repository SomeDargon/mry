package com.mry.service.system;

import com.mry.entity.dao.system.ProductDao;
import com.mry.entity.store.project.ProductManagement;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.json.store.ProjectListJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/12/5.
 */
@Service
@Transactional
public class ProductService extends BaseService {

    @Resource
    private ProductDao productDao;

    public List<ProductManagement> findAllProduct(Long id) {

        List<ProductManagement> users = productDao.findAllProjectt(id);
   //     List<ProjectListJson> json = new ArrayList<ProjectListJson>();
//        if (users.size()>0) {
//            users.forEach(a ->json.add(new ProjectListJson(a)));
//        }
        return users;
    }
}
