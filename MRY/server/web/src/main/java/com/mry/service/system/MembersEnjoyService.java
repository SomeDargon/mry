package com.mry.service.system;

import com.mry.entity.dao.store.MembersEnjoyDao;
import com.mry.entity.store.card.MembersEnjoy;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.annotation.Resource;

/**
 * Created by somedragon on 2018/4/13.
 */
@Service
@Transactional
public class MembersEnjoyService extends BaseService {

    @Resource
    private MembersEnjoyDao membersEnjoyDao;

    public List<MembersEnjoy> findByCardId(Long card_id){
        return membersEnjoyDao.findByCardId(card_id);
    }

}
