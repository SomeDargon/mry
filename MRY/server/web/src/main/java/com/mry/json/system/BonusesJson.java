package com.mry.json.system;


import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/22.
 */
public class BonusesJson<T> {



    //id
    private Long id;
    //奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)
    @ApiModelProperty(value="奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)",name="typeOfBonus")
    private String typeOfBonus;

    //单日客流
    @ApiModelProperty(value="单日客流",name="singleDayPassengerFlow")
    private Integer singleDayPassengerFlow;

    //单日客流奖励
    @ApiModelProperty(value="单日客流奖励",name="oneDayPassengerFlowAward")
    private BigDecimal oneDayPassengerFlowAward;

    //累计客流
    @ApiModelProperty(value="累计客流",name="accumulativePassengerFlow")
    private Integer accumulativePassengerFlow;

    //累计客流奖励
    @ApiModelProperty(value="累计客流奖励",name="accumulativePassengerFlowAward")
    private BigDecimal accumulativePassengerFlowAward;

    //累计客流
//    private List<AccumulativePassengerFlow> accumulativePassengerFlowes;

    //现金业绩奖励
    @ApiModelProperty(value="现金业绩奖励",name="cashRewards")
    private boolean cashRewards;


    //类型
    @ApiModelProperty(value="类型",name="cashType")
    private String cashType;

    //现金业绩奖励
  //  private List<CashReward> cashReward;

    //实操奖励
    @ApiModelProperty(value="实操奖励",name="practiceRewards")
    private boolean practiceRewards;
    private List<T> data;

    //实操奖励
 //   private List<PracticeReward> practiceReward;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfBonus() {
        return typeOfBonus;
    }

    public void setTypeOfBonus(String typeOfBonus) {
        this.typeOfBonus = typeOfBonus;
    }

    public Integer getSingleDayPassengerFlow() {
        return singleDayPassengerFlow;
    }

    public void setSingleDayPassengerFlow(Integer singleDayPassengerFlow) {
        this.singleDayPassengerFlow = singleDayPassengerFlow;
    }

    public BigDecimal getOneDayPassengerFlowAward() {
        return oneDayPassengerFlowAward;
    }

    public void setOneDayPassengerFlowAward(BigDecimal oneDayPassengerFlowAward) {
        this.oneDayPassengerFlowAward = oneDayPassengerFlowAward;
    }

    public Integer getAccumulativePassengerFlow() {
        return accumulativePassengerFlow;
    }

    public void setAccumulativePassengerFlow(Integer accumulativePassengerFlow) {
        this.accumulativePassengerFlow = accumulativePassengerFlow;
    }

    public BigDecimal getAccumulativePassengerFlowAward() {
        return accumulativePassengerFlowAward;
    }

    public void setAccumulativePassengerFlowAward(BigDecimal accumulativePassengerFlowAward) {
        this.accumulativePassengerFlowAward = accumulativePassengerFlowAward;
    }

    public boolean isCashRewards() {
        return cashRewards;
    }

    public void setCashRewards(boolean cashRewards) {
        this.cashRewards = cashRewards;
    }

    public boolean isPracticeRewards() {
        return practiceRewards;
    }

    public void setPracticeRewards(boolean practiceRewards) {
        this.practiceRewards = practiceRewards;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getCashType() {
        return cashType;
    }

    public void setCashType(String cashType) {
        this.cashType = cashType;
    }
}
