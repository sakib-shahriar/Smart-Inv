package com.ssdev.smartinv.model.product;

import com.ssdev.smartinv.model.common.BaseModel;
import com.ssdev.smartinv.model.common.CompoundPrice;
import com.ssdev.smartinv.model.common.PriceType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "price")
public class Price extends BaseModel {
    @Id
    private Long id;

    @Column(name = "price_type", nullable = false)
    private PriceType priceType;

    @Column(nullable = false)
    private Double tax;

    @Column(name = "simple_price", nullable = false)
    private Double simplePrice;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CompoundPrice> compoundPriceList;

    @OneToOne
    @JoinColumn(name = "product_item", nullable = false)
    private ProductItem productItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getSimplePrice() {
        return simplePrice;
    }

    public void setSimplePrice(Double simplePrice) {
        this.simplePrice = simplePrice;
    }

    public List<CompoundPrice> getCompoundPriceList() {
        return compoundPriceList;
    }

    public void setCompoundPriceList(List<CompoundPrice> compoundPriceList) {
        this.compoundPriceList = compoundPriceList;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }
}
