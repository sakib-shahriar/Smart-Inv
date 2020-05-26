package com.ssdev.samrtinv.dao.user;

import com.ssdev.samrtinv.dao.common.Dao;
import com.ssdev.samrtinv.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends Dao<User> {
    @Override
    public Class<User> getModelClass() {
        return User.class;
    }
}
