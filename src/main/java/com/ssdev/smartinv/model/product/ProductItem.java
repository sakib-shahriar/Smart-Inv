package com.ssdev.smartinv.model.product;

import com.ssdev.smartinv.model.common.BaseModel;
import com.ssdev.smartinv.model.common.Item;
import com.ssdev.smartinv.model.common.UOM;
import com.ssdev.smartinv.model.order.OrderItem;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ProductItem extends BaseModel implements Item {
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

    @Column(nullable = false, name = "unit_quantity")
    private Double unitQuantity;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToOne(mappedBy = "productItem", cascade = CascadeType.ALL)
    private Price price;

    @OneToMany(mappedBy = "productItem")
    private List<OrderItem> orderItems;

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

    public Double getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Double unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPriceList(Price price) {
        this.price = price;
    }
}