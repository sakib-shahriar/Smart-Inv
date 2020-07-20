package com.ssdev.smartinv.model.common;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String country;

    @Column(length = 200)
    private String details;

    @Column(name = "post_code", length = 50)
    private String postCode;

    public String getFullAddress() {
        String address =  this.postCode != null ? this.postCode: "";
        address += this.city != null ? ", " + this.city : "";
        address += this.country != null ? ", " + this.country + "." : "";
        address += this.details != null ? "\n" + this.details + "." : "";
        return address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
