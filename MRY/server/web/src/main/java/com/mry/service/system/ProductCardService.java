package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.system.ProductCardDao;
import com.mry.entity.store.card.ProductCardManagement;
import com.mry.json.system.ProductCardJson;
import com.mry.json.system.ProductCardListJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2018/1/10.
 */
@Service
@Transactional
public class ProductCardService extends BaseService {

    @Resource
    public ProductCardDao productCardDao;
    @Resource
    public StoreDao storeDao;

    public int save(ProductCardJson data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        ProductCardManagement card = new ProductCardManagement();
        card.setStoreName(s.getStoreName());
        card.setStoreId(s.getId());
        if(data.getCashPrice() != null && data.getCashPrice()!="") {
            card.setCashPrice(new BigDecimal(data.getCashPrice()));
        }
        if(data.getBucklePrice() != null && data.getBucklePrice()!="") {
            card.setBucklePrice(new BigDecimal(data.getBucklePrice()));
        }
        if (data.getProductCardMoney() != null && data.getProductCardMoney()!=""){
            card.setProductCardMoney(new BigDecimal(data.getProductCardMoney()));
        }
        card.setProductCardName(data.getProductCardName());
        card.setProductCardValidity(data.getProductCardValidity());
        card.setEnable(true);
        productCardDao.saveObject(card);
        return 1;

    }

    public int edit(ProductCardJson data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        ProductCardManagement card = productCardDao.findById(data.getId());
        card.setStoreName(s.getStoreName());
        card.setStoreId(s.getId());
        if(data.getCashPrice() != null && data.getCashPrice()!="") {
            card.setCashPrice(new BigDecimal(data.getCashPrice()));
        }
        if(data.getBucklePrice() != null && data.getBucklePrice()!="") {
            card.setBucklePrice(new BigDecimal(data.getBucklePrice()));
        }
        if (data.getProductCardMoney() != null && data.getProductCardMoney()!=""){
            card.setProductCardMoney(new BigDecimal(data.getProductCardMoney()));
        }
        card.setProductCardName(data.getProductCardName());
        card.setProductCardValidity(data.getProductCardValidity());
        card.setEnable(true);
        productCardDao.updateObject(card);
        return 1;

    }

    public List<ProductCardListJson> findproductCard(Long storeId,String name) {

        List<ProductCardListJson> list = new ArrayList<ProductCardListJson>();
        List<ProductCardManagement> users = productCardDao.findproductCard(storeId,name);
        if (users.size()>0) {
            users.forEach(a ->list.add(new ProductCardListJson(a)));
        }
        return list;
    }

    public int delete(Long id) {

        return productCardDao.delete(id);
    }
}
