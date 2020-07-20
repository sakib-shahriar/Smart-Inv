package com.ssdev.smartinv.dao.product;

import com.ssdev.smartinv.dao.common.Dao;
import com.ssdev.smartinv.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDao extends Dao<Product> {
    @Override
    public Class<Product> getModelClass() {
        return Product.class;
    }
}
