package com.ssdev.smartinv.model.common;
import javax.persistence.*;

@Entity
@Table(name = "compound_price")
public class CompoundPrice extends BaseModel{
    @Id
    private Long id;

    @Column(name = "start_quantity", nullable = false)
    private Double startQuantity;

    @Column(name = "end_quantity", nullable = false)
    private Double endQuantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "default_price", nullable = false)
    private Boolean defaultPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getStartQuantity() {
        return startQuantity;
    }

    public void setStartQuantity(Double startQuantity) {
        this.startQuantity = startQuantity;
    }

    public Double getEndQuantity() {
        return endQuantity;
    }

    public void setEndQuantity(Double endQuantity) {
        this.endQuantity = endQuantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Boolean defaultPrice) {
        this.defaultPrice = defaultPrice;
    }
}
