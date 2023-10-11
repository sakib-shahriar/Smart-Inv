package com.ssdev.smartinv.model.order;

import com.ssdev.smartinv.model.common.BaseModel;
import com.ssdev.smartinv.model.common.Item;
import com.ssdev.smartinv.model.common.UOM;
import com.ssdev.smartinv.model.product.ProductItem;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_item")
public class OrderItem extends BaseModel implements Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private Double total;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(nullable = false)
    private Double tax;

    @OneToOne(mappedBy = "orderItem", cascade = CascadeType.ALL)
    private OrderPrice orderPrice;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }

    public OrderPrice getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(OrderPrice orderPrice) {
        this.orderPrice = orderPrice;
    }
}
