package com.mry.json.system;

import com.mry.entity.store.card.CardProject;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/11/29.
 */
public class CardProjectJson {


    private Long id;
    //项目id
    private Long projectId;

    //项目名称
    private String name;

    //项目价格
    private String price;

    //次数
    private Integer frequency;

    //间隔
    private Integer interval;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public CardProject convert() {
        CardProject c = new CardProject();
        c.setProjectName(this.name);
        c.setProjectId(this.projectId);
        c.setFrequency(this.frequency);
        c.setProjectPrice(new BigDecimal(this.price));
        c.setIntervalTime(this.interval);
        return c;
    }
    public CardProjectJson(CardProject data) {
        this.id = data.getId();
        this.projectId = data.getProjectId();
        this.name = data.getProjectName();
        this.price = data.getProjectPrice().toString();
        this.frequency = data.getFrequency();
        this.interval = data.getIntervalTime();
    }
}
