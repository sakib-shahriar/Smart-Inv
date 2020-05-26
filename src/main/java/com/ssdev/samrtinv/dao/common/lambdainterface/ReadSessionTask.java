package com.ssdev.samrtinv.dao.common.lambdainterface;

import com.ssdev.samrtinv.model.common.BaseModel;
import org.hibernate.Session;

public interface ReadSessionTask<T extends BaseModel> {
    T execute(Session session) throws Exception;
}
