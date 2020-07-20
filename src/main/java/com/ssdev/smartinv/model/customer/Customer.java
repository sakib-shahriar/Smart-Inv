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
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    private String email;

    @Column(length = 15)
    private String mobile;

    @Column(length = 15)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
