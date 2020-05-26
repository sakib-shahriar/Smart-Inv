package com.ssdev.samrtinv.dao.common;

import com.ssdev.samrtinv.model.common.BaseModel;

import java.util.List;

public interface BaseDao<T extends BaseModel> {
    T get(Long id);

    List<T> getAll();

    void save(T obj);

    void delete(T obj);

    Long getCount();

    Class<T> getModelClass();
}
