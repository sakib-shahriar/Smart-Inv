package com.ssdev.smartinv.model.customer;

import com.ssdev.smartinv.model.common.Address;
import com.ssdev.smartinv.model.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String name;

    private String email;

    @Column(length = 15)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
