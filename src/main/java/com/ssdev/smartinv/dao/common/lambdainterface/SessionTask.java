package com.ssdev.smartinv.dao.common.lambdainterface;

import org.hibernate.Session;

public interface SessionTask {
    void execute(Session session) throws Exception;
}
