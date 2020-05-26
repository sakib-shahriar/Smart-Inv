package com.ssdev.samrtinv.dao.common.lambdainterface;

import org.hibernate.Session;

public interface ReadGenericSessionTask<T> {
    T execute(Session session) throws Exception;
}
