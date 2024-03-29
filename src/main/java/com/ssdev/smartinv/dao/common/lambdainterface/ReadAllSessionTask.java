package com.ssdev.smartinv.dao.common.lambdainterface;

import com.ssdev.smartinv.model.common.BaseModel;
import org.hibernate.Session;
import java.util.List;

public interface ReadAllSessionTask<T extends BaseModel> {
    List<T> execute(Session session) throws Exception;
}
