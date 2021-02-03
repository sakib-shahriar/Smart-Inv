package com.ssdev.smartinv.service.common;

import java.util.List;

public abstract class ServiceBase<T, E> {
    public abstract T get(Long id);
    public abstract List<T> getALL();
    public abstract T save(E obj);
    public abstract void delete(T obj);
}
