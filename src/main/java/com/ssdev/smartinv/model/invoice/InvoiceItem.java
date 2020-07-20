package com.ssdev.smartinv.model.invoice;

import com.ssdev.smartinv.model.common.BaseModel;
import com.ssdev.smartinv.model.common.Item;
import com.ssdev.smartinv.model.common.UOM;
import com.ssdev.smartinv.model.order.OrderItem;

import javax.persistence.*;

@Entity
@Table(name = "invoice_item")
public class InvoiceItem extends BaseModel implements Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50)
    private String brand;

    @Column(length = 50, nullable = false)
    private String code;

    @Column(length = 300)
    private String description;

    @Column(nullable = false)
    private UOM uom;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private Integer qty;

    private Double discount;

    private Double total;

    @Column(name = "sub_total")
    private Double subTotal;
 
    @Column(nullable = false)
    private Double tax;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;

    @OneToOne(mappedBy = "invoiceItem")
    private InvoicePrice invoicePrice;

    public Double calculate() {
        return 0D;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UOM getUom() {
        return uom;
    }

    public void setUom(UOM uom) {
        this.uom = uom;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
