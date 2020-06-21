package com.ssdev.samrtinv.model.product;

import com.ssdev.samrtinv.model.common.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
public class Price extends BaseModel {
    @Id
    private Long id;

    @Column(name = "price_type", nullable = false)
    private PriceType priceType;

    @Column(nullable = false)
    private Double tax;

    @Column(name = "simple_price", nullable = false)
    private Double simplePrice;

    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL)
    private List<CompoundPrice> compoundPriceList;

    @ManyToOne
    @JoinColumn(name = "product_item", nullable = false)
    private ProductItem productItem;

    public double getTotal() {
        if(this.priceType == PriceType.SIMPLE) {
            return getSimpleTotal();
        }
        return getComplexTotal();
    }

    private Double getSimpleTotal() {
        return 0.0;
    }

    private Double getComplexTotal() {
        return 0.0;
    }

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
