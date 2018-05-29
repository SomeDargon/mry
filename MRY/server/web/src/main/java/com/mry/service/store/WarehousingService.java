package com.mry.service.store;

import com.mry.entity.dao.store.WarehousingDao;
import com.mry.entity.store.inventory.Warehousing;
import com.mry.entity.store.inventory.WarehousingOut;
import com.mry.entity.user.Staff;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.*;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/11/20.
 */
@Service
@Transactional
public class WarehousingService extends BaseService {


    @Resource
    public WarehousingDao warehousingDao;

    public int save(String authToken, WarehousingJson data) {

        Staff user = getStaffByAuthToken(authToken);

        Warehousing war = new Warehousing();
        war.setStoreId(user.getStoreId());
        war.setStoreName(user.getStoreName());
        war.setName(data.getName());
        war.setCode(data.getCode());
        war.setBrand(data.getBrand());
        war.setQuantity(data.getQuantity());
        war.setStorage(new Date());
        war.setExpiration(DatetimeUtil.parseDate(data.getExpiration()));
        war.setStorageType(data.getStorageType());
        war.setActualQuantity(Integer.valueOf(data.getActualQuantity()));

     //   war.setStatus(data.getStatus());
        war.setSource(data.getSource());
        war.setPurchasePrice(data.getPurchasePrice());
        war.setRetailPrice(data.getRetailPrice());
        war.setDeliveryMan(data.getDeliveryMan());
        war.setEnable(true);

        warehousingDao.saveObject(war);


        return 1;

    }

    public int edit(String authToken, WarehousingJson data) {

        Staff user = getStaffByAuthToken(authToken);
        Warehousing war = warehousingDao.findById(data.getId());
//        war.setStoreId(user.getStoreId());
//        war.setStoreName(user.getStoreName());
        war.setName(data.getName());
        war.setCode(data.getCode());
        war.setBrand(data.getBrand());
        war.setQuantity(data.getQuantity());
        war.setStorage(new Date());
        war.setExpiration(DatetimeUtil.parseDate(data.getExpiration()));
        war.setStorageType(data.getStorageType());
        war.setActualQuantity(Integer.valueOf(data.getActualQuantity()));
        //   war.setStatus(data.getStatus());
        war.setSource(data.getSource());
        war.setPurchasePrice(data.getPurchasePrice());
        war.setRetailPrice(data.getRetailPrice());
        war.setDeliveryMan(data.getDeliveryMan());
        war.setEnable(true);
        warehousingDao.saveObject(war);
        return 1;

    }

    public ResultsWrapper<WarehousingListJson> findWarehousingList(String authToken, String name, Integer page, Integer pageSize) {

        Staff user = getStaffByAuthToken(authToken);
        List<Warehousing> wars = warehousingDao.findWarehousingList(user.getStoreId(),name,page,pageSize);
        List<WarehousingListJson> json = new ArrayList<WarehousingListJson>();
        if (wars.size()>0) {
            wars.forEach(a ->json.add(new WarehousingListJson(a)));
        }
        Long count = warehousingDao.findWarehousingCount(user.getStoreId(),name);

        ResultsWrapper<WarehousingListJson> h = new ResultsWrapper<WarehousingListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public void delete(String authToken, Long id) {
         warehousingDao.delete(id);
    }

    public ResultsWrapper<WarehousingPdJson> findList(String authToken, String name, Integer page, Integer pageSize) {
        Staff user = getStaffByAuthToken(authToken);
        List<WarehousingPdJson> wars = warehousingDao.findList(user.getStoreId(),name,page,pageSize);
//        List<WarehousingPdJson> json = new ArrayList<WarehousingPdJson>();
//        if (wars.size()>0) {
//            wars.forEach(a ->json.add(new WarehousingPdJson(a)));
//        }
        Long count = warehousingDao.findCount(user.getStoreId(),name);

        ResultsWrapper<WarehousingPdJson> h = new ResultsWrapper<WarehousingPdJson>();
        h.setResults(wars);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public StatusJson WarehousingOut(String authToken, String name, String code, String type, String actualQuantity) {
        StatusJson s  = new StatusJson();
        Staff user = getStaffByAuthToken(authToken);
        Integer count = Integer.valueOf(actualQuantity);
        List<WarehousingPdJson> wars = warehousingDao.findSumList(user.getStoreId(),name);
        if(wars.get(0).getActualQuantity()<Integer.valueOf(actualQuantity)){
            s.setMessage("数量不足");
            s.setStatus(1);
        }else{
            List<Warehousing> war = warehousingDao.findSumWarehousingList(user.getStoreId(),name);
            WarehousingOut out  = new WarehousingOut();
            out.setName(name);
            out.setQuantity(actualQuantity);
            out.setStorage(new Date());
            out.setStoreId(user.getStoreId());
            out.setStoreName(user.getStoreName());
            out.setCode(code);
            for(Warehousing w:war){
                if(w.getActualQuantity()>count){
                    w.setActualQuantity(w.getActualQuantity()-count);
                    warehousingDao.updateObject(w);
                    count =0;
                }else{
                    w.setActualQuantity(0);
                    count =count-w.getActualQuantity();
                    warehousingDao.updateObject(w);

                }
            }
            //销售出库
            if(type.equals("0")){
                out.setStorageType("0");
                out.setStatus("0");

                //转入小库
            }else{
                out.setStorageType("1");

            }
            warehousingDao.saveObject(out);
            s.setMessage("成功转出");
            s.setStatus(0);
        }
        return s;

    }

    public ResultsWrapper<WarehousingOutJson> findWarehousinOutgList(String authToken, String name, String type,Integer page, Integer pageSize) {
        Staff user = getStaffByAuthToken(authToken);
        List<WarehousingOut> wars = warehousingDao.findOutList(user.getStoreId(),name,type,page,pageSize);
        List<WarehousingOutJson> json = new ArrayList<WarehousingOutJson>();
        if (wars.size()>0) {
            wars.forEach(a ->json.add(new WarehousingOutJson(a)));
        }
        Long count = warehousingDao.findOurCount(user.getStoreId(),name,type);

        ResultsWrapper<WarehousingOutJson> h = new ResultsWrapper<WarehousingOutJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public List<WarehousingPdJson> findAllList(String authToken) {

        Staff user = getStaffByAuthToken(authToken);
        List<WarehousingPdJson> wars = warehousingDao.findAllList(user.getStoreId());
        return wars;
    }
}
