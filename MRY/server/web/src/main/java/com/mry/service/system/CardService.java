package com.mry.service.system;

import com.mry.entity.dao.system.CardDao;
import com.mry.entity.store.card.CardManagement;
import com.mry.entity.store.card.CardProject;
import com.mry.entity.store.card.GiftItems;
import com.mry.json.ResultsWrapper;
import com.mry.json.system.CardJson;
import com.mry.json.system.CardListJson;
import com.mry.json.system.CardProjectJson;
import com.mry.json.system.GiftItemsJson;
import com.mry.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/11/29.
 */
@Service
@Transactional
public class CardService extends BaseService {

    @Resource
    private CardDao cardDao;

    public int save(String authToken, CardJson data) {
        CardManagement card = new CardManagement();
        card.setName(data.getName());
        card.setCashCoupon(data.getCashCoupon());
        card.setCashPrice(data.getCashPrice());
        card.setBucklePrice(data.getBucklePrice());
        card.setIntroduceRebate(data.getIntroduceRebate());
        card.setGiveGiftsToRespect(data.getGiveGiftsToRespect());
        card.setConsumptionRebate(data.getConsumptionRebate());
        if(data.getCardProject() != null){
            List<CardProject> projects = new ArrayList<>();
            for(CardProjectJson c:data.getCardProject()){
                CardProject project = c.convert();
                project.setCard(card);
                projects.add(project);
            }
            card.setCardProject(projects);
        }

        if(data.getGiftItems() != null){
            List<GiftItems> gifts = new ArrayList<>();
            for(GiftItemsJson g:data.getGiftItems()){
                GiftItems gift = g.convert();
                gift.setCard(card);
                gifts.add(gift);
            }
            card.setGiftItems(gifts);
        }

        card.setEnable(true);
        cardDao.saveObject(card);
        return 1;
    }

    public int edit(String authToken, CardJson data) {

        CardManagement card =cardDao.findById(data.getId());
        cardDao.deleteCardProject(card.getId());
        cardDao.deleteGiftItems(card.getId());
        card.setName(data.getName());
        card.setCashCoupon(data.getCashCoupon());
        card.setCashPrice(data.getCashPrice());
        card.setBucklePrice(data.getBucklePrice());
        card.setIntroduceRebate(data.getIntroduceRebate());
        card.setGiveGiftsToRespect(data.getGiveGiftsToRespect());
        card.setConsumptionRebate(data.getConsumptionRebate());
        if(data.getCardProject() != null){
            List<CardProject> projects = new ArrayList<>();
            for(CardProjectJson c:data.getCardProject()){
                CardProject project = c.convert();
                project.setCard(card);
                projects.add(project);
            }
            card.setCardProject(projects);
        }

        if(data.getGiftItems() != null){
            List<GiftItems> gifts = new ArrayList<>();
            for(GiftItemsJson g:data.getGiftItems()){
                GiftItems gift = g.convert();
                gift.setCard(card);
                gifts.add(gift);
            }
            card.setGiftItems(gifts);
        }

        card.setEnable(true);
        cardDao.saveObject(data);
        return 1;
    }

    public ResultsWrapper<CardListJson> findCardList(String name, Integer page, Integer pageSize) {
      //  Staff user = getStaffByAuthToken(authToken);
        List<CardManagement> cards = cardDao.findCards(name,page,pageSize);
        List<CardListJson> json = new ArrayList<CardListJson>();
        if (cards.size()>0) {
            cards.forEach(a ->json.add(new CardListJson(a)));
        }
        Long count = cardDao.findCardsCount(name);

        ResultsWrapper<CardListJson> h = new ResultsWrapper<CardListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }

    public CardListJson findById(Long id) {

        CardManagement card =cardDao.findById(id);
        CardListJson c = new CardListJson(card);
        return c;
    }
}
