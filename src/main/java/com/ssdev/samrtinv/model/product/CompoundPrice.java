package com.ssdev.samrtinv.model.product;

import com.ssdev.samrtinv.model.common.BaseModel;

import javax.persistence.*;

@Entity
public class CompoundPrice extends BaseModel {
    @Id
    private Long id;

    @Column(nullable = false)
    private Double from;

    @Column(nullable = false)
    private Double to;

    @Column(nullable = false)
    private Double unitPrice;

    @Column(name = "default_price", nullable = false)
    private Boolean defaultPrice;

    @ManyToOne
    @JoinColumn(name = "price_id", nullable = false)
    private Price price;
}
