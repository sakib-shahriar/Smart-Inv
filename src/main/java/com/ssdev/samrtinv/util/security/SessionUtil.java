package com.ssdev.samrtinv.util.security;

import com.ssdev.samrtinv.model.user.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static User getLoggedInUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    public static void setLoggedInUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute("user", user);
    }

    public static void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
    }

    public static void put(String key, Object value, HttpServletRequest request) {
        request.getSession().setAttribute(key, value);
    }

    public static Object get(String key, HttpServletRequest request) {
        return request.getSession().getAttribute(key);
    }
}
