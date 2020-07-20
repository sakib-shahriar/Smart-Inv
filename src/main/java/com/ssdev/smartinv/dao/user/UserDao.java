package com.ssdev.smartinv.dao.user;

import com.ssdev.smartinv.dao.common.Dao;
import com.ssdev.smartinv.dto.AuthenticationDTO;
import com.ssdev.smartinv.model.user.User;
import com.ssdev.smartinv.util.security.CryptoUtil;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends Dao<User> {
    @Override
    public Class<User> getModelClass() {
        return User.class;
    }

    public User isValidUser(AuthenticationDTO authenticationDTO) {
        User user = read(session -> {
            String password = CryptoUtil.encrypt(authenticationDTO.getPassword());
            Query query =  session.createQuery("from User where email=:em and password=:pass");
            query.setParameter("em", authenticationDTO.getEmail());
            query.setParameter("pass", password);
            User usr = (User) query.uniqueResult();
            return usr;
        });
        return user;
    }
}
