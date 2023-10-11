package com.ssdev.smartinv.model.invoice;

import com.ssdev.smartinv.model.common.BaseModel;
import com.ssdev.smartinv.model.common.CompoundPrice;
import com.ssdev.smartinv.model.common.PriceType;
import com.ssdev.smartinv.model.order.OrderPrice;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "invoice_price")
public class InvoicePrice extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "invoice_item_id", nullable = false)
    private InvoiceItem invoiceItem;

    @OneToOne
    @JoinColumn(name = "order_price_id", nullable = false)
    private OrderPrice orderPrice;

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

    public InvoiceItem getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public OrderPrice getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(OrderPrice orderPrice) {
        this.orderPrice = orderPrice;
    }
}
