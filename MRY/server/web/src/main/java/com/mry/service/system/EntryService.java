package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.system.EntryDao;
import com.mry.entity.store.EntryInformation;
import com.mry.json.system.EntryJson;
import com.mry.json.system.EntryListJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/12/28.
 */
@Service
@Transactional
public class EntryService extends BaseService {

    @Resource
    public EntryDao entryDao;

    @Resource
    public StoreDao storeDao;

    public int save(EntryJson data) {
        StoreManagement s = storeDao.findById(data.getId());
        EntryInformation e = new EntryInformation();
        e.setStoreId(s.getId());
        e.setStoreName(s.getStoreName());
        e.setEntryName(data.getEntryName());
        e.setEntryExplain(data.getEntryExplain());
        e.setEnable(true);
        entryDao.saveObject(e);

        return 1;
    }

    public int edit(EntryJson data) {
        StoreManagement s = storeDao.findById(data.getId());
        EntryInformation e = entryDao.findById(data.getId());
        e.setStoreId(s.getId());
        e.setStoreName(s.getStoreName());
        e.setEntryName(data.getEntryName());
        e.setEntryExplain(data.getEntryExplain());
        entryDao.saveObject(e);

        return 1;
    }

    public List<EntryListJson> findEntry(Long id,String name) {
        List<EntryListJson> list = entryDao.findEntry(id,name);
        return list;
    }

    public int delete(Long id) {
        return entryDao.delete(id);
    }
}
