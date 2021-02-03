package com.ssdev.smartinv.dao.customer;

import com.ssdev.smartinv.dao.common.Dao;
import com.ssdev.smartinv.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao extends Dao<Customer> {
    @Override
    public Class<Customer> getModelClass() {
        return Customer.class;
    }
}
