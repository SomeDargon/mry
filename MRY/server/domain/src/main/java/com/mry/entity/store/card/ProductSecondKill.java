package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.project.ProductManagement;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/11.
 * 产品秒杀
 */
@Entity
@Table(name = ProductSecondKill.TABLE_NAME)
public class ProductSecondKill extends BaseEntity {

    public static final String TABLE_NAME = "product_second_kill";

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private ActivityCardManagement activity;

    // 现金秒杀价格
    @Column(name = "cash_second_price")
    private BigDecimal cashSecondPrice ;

    // 卡扣秒杀价格
    @Column(name = "buckle_the_second_price")
    private BigDecimal buckleTheSecondPrice ;

    //产品
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductManagement product;

    public ActivityCardManagement getActivity() {
        return activity;
    }

    public void setActivity(ActivityCardManagement activity) {
        this.activity = activity;
    }

    public BigDecimal getCashSecondPrice() {
        return cashSecondPrice;
    }

    public void setCashSecondPrice(BigDecimal cashSecondPrice) {
        this.cashSecondPrice = cashSecondPrice;
    }

    public BigDecimal getBuckleTheSecondPrice() {
        return buckleTheSecondPrice;
    }

    public void setBuckleTheSecondPrice(BigDecimal buckleTheSecondPrice) {
        this.buckleTheSecondPrice = buckleTheSecondPrice;
    }

    public ProductManagement getProduct() {
        return product;
    }

    public void setProduct(ProductManagement product) {
        this.product = product;
    }
}
