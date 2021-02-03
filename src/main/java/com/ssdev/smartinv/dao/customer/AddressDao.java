package com.ssdev.smartinv.dao.customer;

import com.ssdev.smartinv.dao.common.Dao;
import com.ssdev.smartinv.model.common.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDao extends Dao<Address> {
    @Override
    public Class<Address> getModelClass() {
        return Address.class;
    }
}
