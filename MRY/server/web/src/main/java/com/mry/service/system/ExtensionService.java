package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ProjectDao;
import com.mry.entity.dao.system.ExtensionDao;
import com.mry.entity.store.card.ExtensionCardManagement;
import com.mry.entity.store.card.ExtensionCardProject;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.json.system.ExtensionJson;
import com.mry.json.system.ExtensionListJson;
import com.mry.json.system.ExtensionProjectJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 */
@Service
@Transactional
public class ExtensionService  extends BaseService {

    @Resource
    public ExtensionDao extensionDao;

    @Resource
    public StoreDao storeDao;

    @Resource
    public ProjectDao projectDao;

    public ExtensionCardManagement findById(Long id){
        return extensionDao.findById(id);
    }


    public int save(ExtensionJson data) {
        StoreManagement store = storeDao.findById(data.getStoreId());
        ExtensionCardManagement ex = new ExtensionCardManagement();
        ex.setEnable(true);
        ex.setStoreId(store.getId());
        ex.setStoreName(store.getStoreName());
        ex.setExtensionName(data.getExtensionName());
        if(data.getCashPrice() != null && data.getCashPrice()!="") {
            ex.setCashPrice(new BigDecimal(data.getCashPrice()));
        }
        if(data.getBucklePrice() != null && data.getBucklePrice()!="") {
            ex.setBucklePrice(new BigDecimal(data.getBucklePrice()));
        }
        ex.setExtensionValidity(data.getExtensionValidity());
        if(data.getPerformance() != null && data.getPerformance()!=""){
            ex.setPerformance(new BigDecimal(data.getPerformance()));
        }
        if(data.getActualOperation() != null && data.getActualOperation()!=""){
            ex.setActualOperation(new BigDecimal(data.getActualOperation()));
        }
        if(data.getManualFee() != null && data.getManualFee()!=""){
            ex.setManualFee(new BigDecimal(data.getActualOperation()));
        }
        ex.setQuantity(data.getQuantity());
        if(data.getReward() != null  && data.getReward()!=""){
            ex.setReward(new BigDecimal(data.getReward()));
        }

        if(data.getExceedReward() != null  && data.getExceedReward()!=""){
            ex.setExceedReward(new BigDecimal(data.getExceedReward()));
        }
        if(data.getProject() != null){
            List<ExtensionCardProject> es = new ArrayList<>();
            for(ExtensionProjectJson e:data.getProject()) {


                ExtensionCardProject p = new ExtensionCardProject();
                if (e.getProjectId() != null) {
                    ProjectManagement j = projectDao.findById(e.getProjectId());
                    p.setProject(j);
                }
                //  p.setExtensionValidity(e.getExtensionValidity());
                p.setExtensionNumber(e.getExtensionNumber());
                p.setCard(ex);
                es.add(p);
            }
            ex.setProject(es);
        }
        extensionDao.saveObject(ex);
        return 1;

    }

    public int edit(ExtensionJson data) {


        StoreManagement store = storeDao.findById(data.getStoreId());
        ExtensionCardManagement ex = extensionDao.findById(data.getId());
        extensionDao.deleteProjectByEx(data.getId());
        ex.setEnable(true);
        ex.setStoreId(store.getId());
        ex.setStoreName(store.getStoreName());
        ex.setExtensionName(data.getExtensionName());
        ex.setExtensionName(data.getExtensionName());
        if(data.getCashPrice() != null && data.getCashPrice()!="") {
            ex.setCashPrice(new BigDecimal(data.getCashPrice()));
        }
        if(data.getBucklePrice() != null && data.getBucklePrice()!="") {
            ex.setBucklePrice(new BigDecimal(data.getBucklePrice()));
        }
        ex.setExtensionValidity(data.getExtensionValidity());
        if(data.getPerformance() != null && data.getPerformance()!=""){
            ex.setPerformance(new BigDecimal(data.getPerformance()));
        }
        if(data.getActualOperation() != null && data.getActualOperation()!=""){
            ex.setActualOperation(new BigDecimal(data.getActualOperation()));
        }
        if(data.getManualFee() != null && data.getManualFee()!=""){
            ex.setManualFee(new BigDecimal(data.getActualOperation()));
        }
        ex.setQuantity(data.getQuantity());
        if(data.getReward() != null  && data.getReward()!=""){
            ex.setReward(new BigDecimal(data.getReward()));
        }
        if(data.getExceedReward() != null  && data.getExceedReward()!=""){
            ex.setExceedReward(new BigDecimal(data.getExceedReward()));
        }
        if(data.getProject() != null){
            List<ExtensionCardProject> es = new ArrayList<>();
            for(ExtensionProjectJson e:data.getProject()) {


                ExtensionCardProject p = new ExtensionCardProject();
                if (e.getProjectId() != null) {
                    ProjectManagement j = projectDao.findById(e.getProjectId());
                    p.setProject(j);
                }
                //  p.setExtensionValidity(e.getExtensionValidity());
                p.setExtensionNumber(e.getExtensionNumber());
                p.setCard(ex);
                es.add(p);
            }
            ex.setProject(es);
        }
        extensionDao.saveObject(ex);
        return 1;
    }


    public List<ExtensionListJson> findExtension(Long storeId,String name) {
        List<ExtensionListJson> list = new ArrayList<ExtensionListJson>();
        List<ExtensionCardManagement> users = extensionDao.findExtension(storeId,name);
        if (users.size()>0) {
            users.forEach(a ->list.add(new ExtensionListJson(a)));
        }
        return list;

    }

    public int delete(Long id) {

        return extensionDao.delete(id);
    }
}
