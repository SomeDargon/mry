package com.mry.json.system;

import com.mry.entity.store.salary.AccumulativePassengerFlow;
import com.mry.entity.store.salary.CashReward;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/19.
 */
public class SalaryBonusesJson<T> {


    //奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)
    private String typeOfBonus;

    //单日客流
    private Integer singleDayPassengerFlow;

    //单日客流奖励
    private BigDecimal oneDayPassengerFlowAward;

    //累计客流
    private Integer accumulativePassengerFlow;

    //累计客流奖励
    private BigDecimal accumulativePassengerFlowAward;

    //累计客流
 //   private List<AccumulativePassengerFlow> accumulativePassengerFlows;

    // 现金业绩奖励
 //   private List<CashReward> cashReward;

    //实操奖励
    private List<T> data;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
