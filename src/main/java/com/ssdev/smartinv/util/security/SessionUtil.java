package com.ssdev.smartinv.util.security;

import com.ssdev.smartinv.model.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class SessionUtil {
    public static User getLoggedInUser() {
        User user = (User) getSession().getAttribute("user");
        return user;
    }

    public static void setLoggedInUser(User user) {
        getSession().setAttribute("user", user);
    }

    public static void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
    }

    public static void put(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object get(String key, HttpServletRequest request) {
        return getSession().getAttribute(key);
    }

    private static HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        return session;
    }
}
