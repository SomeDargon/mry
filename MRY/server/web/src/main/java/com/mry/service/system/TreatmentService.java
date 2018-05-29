package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ProjectDao;
import com.mry.entity.dao.system.PostDao;
import com.mry.entity.dao.system.TreatmentDao;
import com.mry.entity.store.card.ExtensionCardManagement;
import com.mry.entity.store.card.ExtensionCardProject;
import com.mry.entity.store.card.TreatmentCardManagement;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.json.system.*;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2018/1/7.
 */
@Service
@Transactional
public class TreatmentService extends BaseService {

    @Resource
    public TreatmentDao treatmentDao;

    @Resource
    public StoreDao storeDao;

    @Resource
    public ProjectDao projectDao;

    public TreatmentCardManagement findById(Long id){
        return treatmentDao.findById(id);
    }

    public int save(TreatmentJson data) {
        StoreManagement store = storeDao.findById(data.getStoreId());
        TreatmentCardManagement tean = new TreatmentCardManagement();
        tean.setEnable(true);
        tean.setStoreId(store.getId());
        tean.setStoreName(store.getStoreName());
        tean.setTreatmentName(data.getTreatmentName());
        tean.setTreatmentNumber(data.getTreatmentNumber());
        tean.setTreatmentCardValidity(data.getTreatmentCardValidity());
        tean.setDisplay(data.getDisplay());
        if(data.getCashPrice() != null && data.getCashPrice()!="") {
            tean.setCashPrice(new BigDecimal(data.getCashPrice()));
        }
        if(data.getBucklePrice() != null && data.getBucklePrice()!="") {
            tean.setBucklePrice(new BigDecimal(data.getBucklePrice()));
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
                p.setTreatment(tean);
                es.add(p);
            }
            tean.setProject(es);
        }
        treatmentDao.saveObject(tean);
        return 1;

    }

    public int edit(TreatmentJson data) {

        StoreManagement store = storeDao.findById(data.getStoreId());
        TreatmentCardManagement tean = treatmentDao.findById(data.getId());
        tean.setEnable(true);
        tean.setStoreId(store.getId());
        tean.setStoreName(store.getStoreName());
        tean.setTreatmentNumber(data.getTreatmentNumber());
        tean.setTreatmentName(data.getTreatmentName());
        tean.setTreatmentCardValidity(data.getTreatmentCardValidity());
        tean.setDisplay(data.getDisplay());
        if(data.getCashPrice() != null && data.getCashPrice()!="") {
            tean.setCashPrice(new BigDecimal(data.getCashPrice()));
        }
        if(data.getBucklePrice() != null && data.getBucklePrice()!="") {
            tean.setBucklePrice(new BigDecimal(data.getBucklePrice()));
        }
        treatmentDao.deleteProjectById(data.getId());
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
                p.setTreatment(tean);
                es.add(p);
            }
            tean.setProject(es);
        }
        treatmentDao.saveObject(tean);
        return 1;
    }

    public List<TreatmentJsonListJson> findTreatment(Long storeId,String name) {
        List<TreatmentJsonListJson> list = new ArrayList<TreatmentJsonListJson>();
        List<TreatmentCardManagement> users = treatmentDao.findTreatment(storeId,name);
        if (users.size()>0) {
            users.forEach(a ->list.add(new TreatmentJsonListJson(a)));
        }
        return list;

    }

    public int delete(Long id) {
        return treatmentDao.delete(id);
    }
}
