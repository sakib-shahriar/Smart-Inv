package com.ssdev.smartinv.service.user;
import com.ssdev.smartinv.dao.user.UserDao;
import com.ssdev.smartinv.dto.AuthenticationDTO;
import com.ssdev.smartinv.model.user.User;
import com.ssdev.smartinv.util.security.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserService {

    @Autowired
    private UserDao userDao;

    public User authenticateUser(AuthenticationDTO authenticationDTO) {
        return this.userDao.isValidUser(authenticationDTO);
    }

    public void doAfterLoginUserTask(User user) {
        SessionUtil.setLoggedInUser(user);
    }

    public void logout(HttpServletRequest request) {
        SessionUtil.destroySession(request);
    }
}
