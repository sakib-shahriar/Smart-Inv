package com.ssdev.smartinv.dao.common.lambdainterface;

import com.ssdev.smartinv.model.common.BaseModel;
import org.hibernate.Session;

public interface ReadSessionTask<T extends BaseModel> {
    T execute(Session session) throws Exception;
}
