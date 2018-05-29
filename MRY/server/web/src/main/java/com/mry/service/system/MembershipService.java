package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ProjectDao;
import com.mry.entity.dao.system.MembershipDao;
import com.mry.entity.store.card.MembersEnjoy;
import com.mry.entity.store.card.MembershipCardManagement;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.json.system.MembersEnjoyJson;
import com.mry.json.system.MembershipJson;
import com.mry.json.system.MembershipListJson;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 * 会员卡管理
 */
@Service
@Transactional
public class MembershipService  extends BaseService {

    @Resource
    public MembershipDao membershipDao;
    @Resource
    public StoreDao storeDao;

    @Resource
    public ProjectDao projectDao;

    public MembershipCardManagement findById(Long id){
        return membershipDao.findById(id);
    }

    public int save(MembershipJson data) {
        StoreManagement store = storeDao.findById(data.getStoreId());
        MembershipCardManagement card = new MembershipCardManagement();
        card.setStoreName(store.getStoreName());
        card.setStoreId(store.getId());
        card.setLiftCardType(data.getLiftCardType());
        card.setMembershipName(data.getMembershipName());
        if (data.getMembershipMoney() != null && data.getMembershipMoney() != "") {
            card.setMembershipMoney(new BigDecimal(data.getMembershipMoney()));
        }
        card.setProductDiscount(data.getProductDiscount());
        card.setSettingTime(data.getSettingTime());

        // card.setProductDiscount(data.getProductDiscount());
        card.setMembershipValidity(data.getMembershipValidity());

        if (data.getMemberDay() != null && data.getMemberDay() != "") {
            card.setMemberDay(data.getMemberDay());
        }
        if (data.getProjectDiscount() != null){
            card.setProjectDiscount(Double.valueOf(data.getProjectDiscount()));
        }
        card.setMemberDayNtoStore(data.getMemberDayNtoStore());
        card.setMemberDayNProject(data.getMemberDayNProject());
        card.setMemberDayDiscount(data.getMemberDayDiscount());
        card.setMemberReturnNtoStore(data.getMemberReturnNtoStore());
        card.setMemberReturnNProject(data.getMemberReturnNProject());
        if(data.getReturnAmount() != null && data.getReturnAmount()!="") {
            card.setReturnAmount(new BigDecimal(data.getReturnAmount()));
        }
        card.setReturnValidity(data.getReturnValidity());
        card.setPrecautions(data.getPrecautions());

        if(data.getEnjoy()!= null){
            List<MembersEnjoy> en = new ArrayList<>();
            for(MembersEnjoyJson e:data.getEnjoy()){
                MembersEnjoy gift = new MembersEnjoy();
                if(e.getProjectId()!= null) {
                    ProjectManagement p = projectDao.findById(e.getProjectId());
                    gift.setProject(p);
                }
                gift.setAgingType(e.getAgingType());
                gift.setEnjoyNumber(e.getEnjoyNumber());
                gift.setEnjoyValidity(e.getEnjoyValidity());
                gift.setCard(card);
                en.add(gift);
            }
            card.setEnjoy(en);
        }

        card.setEnable(true);
        membershipDao.save(card);
        return 1;
    }


    public int edit(MembershipJson data) {

        StoreManagement store = storeDao.findById(data.getStoreId());
        MembershipCardManagement card = membershipDao.findById(data.getId());
        card.setStoreName(store.getStoreName());
        card.setStoreId(store.getId());
        card.setLiftCardType(data.getLiftCardType());
        card.setSettingTime(data.getSettingTime());
        card.setMembershipName(data.getMembershipName());
        if(data.getMembershipMoney() != null && data.getMembershipMoney()!="") {
            card.setMembershipMoney(new BigDecimal(data.getMembershipMoney()));
        }
        card.setProductDiscount(data.getProductDiscount());
        if (data.getProjectDiscount() != null){
            card.setProjectDiscount(Double.valueOf(data.getProjectDiscount()));
        }

      //  card.setProductDiscount(data.getProductDiscount());
        card.setMembershipValidity(data.getMembershipValidity());

        if(data.getMemberDay() != null && data.getMemberDay()!="") {
            card.setMemberDay(data.getMemberDay());
        }
        card.setMemberDayNtoStore(data.getMemberDayNtoStore());
        card.setMemberDayNProject(data.getMemberDayNProject());
        card.setMemberDayDiscount(data.getMemberDayDiscount());
        card.setMemberReturnNtoStore(data.getMemberReturnNtoStore());
        card.setMemberReturnNProject(data.getMemberReturnNProject());
        if(data.getReturnAmount() != null && data.getReturnAmount()!="") {
            card.setReturnAmount(new BigDecimal(data.getReturnAmount()));
        }
        card.setReturnValidity(data.getReturnValidity());
        card.setPrecautions(data.getPrecautions());
        membershipDao.deleteCardProject(card.getId());

        if(data.getEnjoy()!= null){

            List<MembersEnjoy> en = new ArrayList<>();
            for(MembersEnjoyJson e:data.getEnjoy()){
                MembersEnjoy gift = new MembersEnjoy();
                if(e.getProjectId()!= null) {
                    ProjectManagement p = projectDao.findById(e.getProjectId());
                    gift.setProject(p);
                }
                gift.setAgingType(e.getAgingType());
                gift.setEnjoyNumber(e.getEnjoyNumber());
                gift.setEnjoyValidity(e.getEnjoyValidity());
                gift.setCard(card);
                en.add(gift);
            }
            card.setEnjoy(en);
        }
        card.setEnable(true);
        membershipDao.save(card);
        return 1;
    }


    public List<MembershipListJson> findMembership(Long storeId,String name) {

        List<MembershipListJson> list = new ArrayList<MembershipListJson>();
        List<MembershipCardManagement> users = membershipDao.findMembership(storeId,name);
        if (users.size()>0) {
            users.forEach(a ->list.add(new MembershipListJson(a)));
        }

        return list;
    }

    public int delete(Long id) {
        return membershipDao.delete(id);
    }
}
