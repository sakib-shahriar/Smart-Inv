package com.ssdev.smartinv.model.order;

import com.ssdev.smartinv.model.common.CompoundPrice;
import com.ssdev.smartinv.model.product.Price;
import com.ssdev.smartinv.model.common.PriceType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_price")
public class OrderPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;

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

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
