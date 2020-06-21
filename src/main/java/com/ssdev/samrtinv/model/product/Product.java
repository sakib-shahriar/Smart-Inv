package com.ssdev.samrtinv.model.product;

import com.ssdev.samrtinv.model.common.BaseModel;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String code;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductItem> productItems;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}