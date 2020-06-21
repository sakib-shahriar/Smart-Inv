package com.ssdev.samrtinv.dao.product;

import com.ssdev.samrtinv.dao.common.Dao;
import com.ssdev.samrtinv.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDao extends Dao<Product> {
    @Override
    public Class<Product> getModelClass() {
        return Product.class;
    }
}
