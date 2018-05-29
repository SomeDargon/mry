package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.system.PostDao;
import com.mry.entity.store.PostManagement;
import com.mry.json.ResultsWrapper;
import com.mry.json.system.PostListJson;
import com.mry.json.system.PostManagementJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/12/25.
 */
@Service
@Transactional
public class PostService extends BaseService {

    @Resource
    public PostDao postDao;
    @Resource
    public StoreDao storeDao;



    public int save(String authToken, PostManagementJson data) {


        StoreManagement s = storeDao.findById(data.getStoreId());
        PostManagement p = new PostManagement();
        p.setEnable(true);
        p.setEmployeeRank(data.getEmployeeRank());
        p.setEmployeeType(data.getEmployeeType());
        p.setStoreId(s.getId());
        p.setStoreName(s.getStoreName());
        p.setPostName(data.getPostName());
        p.setPostDuties(data.getPostDuties());
        p.setWorkflow(data.getWorkflow());
        p.setCheckWorkAttendance(data.getCheckWorkAttendance());
        p.setTechnicalExamination(data.getTechnicalExamination());
        p.setAchievements(data.getAchievements());
        if(data.getMultiMonthCash() != null){
            p.setMultiMonthCash(new BigDecimal(data.getMultiMonthCash()));
        }
        p.setDataRankings(data.getDataRankings());
        if(data.getShareAmount() != null){
           p.setShareAmount(new BigDecimal(data.getShareAmount()));
        }
        p.setDividendManagement(data.getDividendManagement());
        p.setNatureOfEquity(data.getNatureOfEquity());
        postDao.saveObject(p);
        return 1;
    }

    public int edit(String authToken, PostManagementJson data) {

        StoreManagement s = storeDao.findById(data.getStoreId());
        PostManagement p = postDao.findById(data.getId());
        p.setEmployeeRank(data.getEmployeeRank());
        p.setEmployeeType(data.getEmployeeType());
        p.setEnable(true);
        p.setStoreId(s.getId());
        p.setStoreName(s.getStoreName());
        p.setPostName(data.getPostName());
        p.setPostDuties(data.getPostDuties());
        p.setWorkflow(data.getWorkflow());
        p.setCheckWorkAttendance(data.getCheckWorkAttendance());
        p.setTechnicalExamination(data.getTechnicalExamination());
        p.setAchievements(data.getAchievements());
        if(data.getMultiMonthCash() != null){
            p.setMultiMonthCash(new BigDecimal(data.getMultiMonthCash()));
        }
        p.setDataRankings(data.getDataRankings());
        if(data.getShareAmount() != null){
            p.setShareAmount(new BigDecimal(data.getShareAmount()));
        }
        p.setDividendManagement(data.getDividendManagement());
        p.setNatureOfEquity(data.getNatureOfEquity());
        postDao.saveObject(p);
        return 1;
    }

    public ResultsWrapper<PostListJson> findPostList(Long id, String name, Integer page, Integer pageSize) {

        List<PostManagement> post = postDao.findList(id,name,page,pageSize);
        List<PostListJson> json = new ArrayList<PostListJson>();
        if (post.size()>0) {
            post.forEach(a -> json.add(new PostListJson(a)));
        }
        Long count = postDao.findListCount(id,name);

        ResultsWrapper<PostListJson> h = new ResultsWrapper<PostListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));
        return h;
    }

    public void delete(String authToken, Long id) {
        postDao.delete(id);
    }
}
