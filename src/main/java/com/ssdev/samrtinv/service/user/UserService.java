package com.ssdev.samrtinv.service.user;
import com.ssdev.samrtinv.dao.user.UserDao;
import com.ssdev.samrtinv.dto.AuthenticationDTO;
import com.ssdev.samrtinv.model.user.User;
import com.ssdev.samrtinv.util.security.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

@Repository
public class UserService {

    @Autowired
    private UserDao userDao;

    public User authenticateUser(AuthenticationDTO authenticationDTO) {
        return this.userDao.isValidUser(authenticationDTO);
    }

    public void doAfterLoginUserTask(User user, HttpServletRequest request) {
        SessionUtil.setLoggedInUser(request, user);
    }

    public void logout(HttpServletRequest request) {
        SessionUtil.destroySession(request);
    }
}
