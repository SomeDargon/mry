package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ProjectDao;
import com.mry.entity.dao.system.ProblemDao;
import com.mry.entity.store.customer.ProblemDescription;
import com.mry.entity.store.customer.Solution;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/11/28.
 */
@Service
@Transactional
public class ProblemService extends BaseService {

    @Resource
    private ProblemDao problemDao;

    @Resource
    public StoreDao storeDao;

    @Resource
    public ProjectDao projectDao;

    public int save(String authToken, ProblemDescription data) {
        StoreManagement store = storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        String str ="";
        String sr ="";

        problemDao.saveObject(data);
        return 1;
    }

    public int edit(String authToken, ProblemDescription data) {
        StoreManagement store = storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        problemDao.updateObject(data);
        return 1;
    }

    public List<ProblemDescription> findProblemList(Long id) {
        List<ProblemDescription> pro = problemDao.findList(id);
        return pro;
    }

    public int delete(String authToken, Long id) {
        return problemDao.delete(id);
    }

    public int saveSolution(String authToken, Solution data) {
        ProblemDescription pd = problemDao.findById(data.getProblemId());
        StoreManagement store = storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        data.setProblemName(pd.getProblem());
        String str ="";
        String sr ="";
        if(data.getBasicProgrammeIds() != null && data.getBasicProgrammeIds() !="") {
            String[] ids = data.getBasicProgrammeIds().split(",");

            for(int i=0;i<ids.length;i++){
                Long id= Long.valueOf(ids[i]);
                ProjectManagement p = projectDao.findById(id);
                if(i==0){
                    str =p.getProjectName();
                }else {
                    str = str+","+p.getProjectName();
                }
            }
            data.setBasicProgramme(str);
        }
        if(data.getBasicProgrammeIds() != null && data.getBasicProgrammeIds() !="") {
            String[] oids = data.getOptimalSchemeIds().split(",");

            for(int i=0;i<oids.length;i++){
                Long id= Long.valueOf(oids[i]);
                ProjectManagement p = projectDao.findById(id);
                if(i==0){
                    sr =p.getProjectName();
                }else {
                    sr = sr+","+p.getProjectName();
                }
            }
            data.setOptimalScheme(sr);
        }
        data.setEnable(true);
        data.setOptimalScheme(sr);
        data.setBasicProgramme(str);
        problemDao.saveObject(data);
        return 1;
    }

    public int editSolution(String authToken, Solution data) {

        String str ="";
        if(data.getBasicProgrammeIds() != null && data.getBasicProgrammeIds() !="") {
            String[] ids = data.getBasicProgrammeIds().split(",");

            for(int i=0;i<ids.length;i++){
                Long id= Long.valueOf(ids[i]);
                ProjectManagement p = projectDao.findById(id);
                if(i==0){
                    str =p.getProjectName();
                }else {
                    str = str+","+p.getProjectName();
                }
            }
            data.setBasicProgramme(str);
        }
        String sr ="";
        if(data.getBasicProgrammeIds() != null && data.getBasicProgrammeIds() !="") {
            String[] oids = data.getOptimalSchemeIds().split(",");

            for(int i=0;i<oids.length;i++){
                Long id= Long.valueOf(oids[i]);
                ProjectManagement p = projectDao.findById(id);
                if(i==0){
                    sr =p.getProjectName();
                }else {
                    sr = sr+","+p.getProjectName();
                }
            }
            data.setOptimalScheme(sr);
        }
        data.setOptimalScheme(sr);
        data.setBasicProgramme(str);
        data.setEnable(true);
        problemDao.updateObject(data);
        return 1;
    }

    public List<Solution> findSolutionList(Long id) {
        List<Solution> pro = problemDao.findSolutionList(id);
        return pro;
    }

    public int deleteSolution(String authToken, Long id) {
            return problemDao.deleteSolution(id);
    }
}
