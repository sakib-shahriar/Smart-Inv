package com.ssdev.samrtinv.model.product;

import com.ssdev.samrtinv.model.common.BaseModel;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductItem extends BaseModel {
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

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL)
    private List<Price> priceList;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }
}