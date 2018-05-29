package com.mry.json.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/29.
 * 客流奖励
 */
@Api(description="客流奖励", value = "客流奖励")
public class PassengerFlowAwardJson {
    //薪资id
    private Long id;

    //单日客流
    @ApiModelProperty(value="单日客流",name="singleDayPassengerFlow")
    private Integer singleDayPassengerFlow;

    //单日客流奖励
    @ApiModelProperty(value="单日客流奖励",name="oneDayPassengerFlowAward")
    private BigDecimal oneDayPassengerFlowAward;

    //累计客流
    @ApiModelProperty(value="单日客流奖励",name="accumulativePassengerFlow")
    private Integer accumulativePassengerFlow;

    //累计客流奖励
    @ApiModelProperty(value="单日客流奖励",name="accumulativePassengerFlowAward")
    private BigDecimal accumulativePassengerFlowAward;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
