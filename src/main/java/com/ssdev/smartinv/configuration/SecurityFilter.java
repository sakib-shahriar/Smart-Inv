package com.ssdev.smartinv.configuration;

import com.ssdev.smartinv.model.user.User;
import com.ssdev.smartinv.util.security.SessionUtil;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    private static final String LOGIN_URL = "/login";
    private static final String AUTH_URL = "/authenticate";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = SessionUtil.getLoggedInUser();

        String baseUrl = String.format("%s://%s:%d%s",request.getScheme(),  request.getServerName(), request.getServerPort(), request.getContextPath());
        String loginUrl = baseUrl + LOGIN_URL;
        String authUrl = baseUrl + AUTH_URL;
        String requestUrl = request.getRequestURL().toString();
        if(!requestUrl.equals(authUrl) && !requestUrl.equals(loginUrl) && user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        else if(requestUrl.equals(loginUrl) && user != null) {
            response.sendRedirect(request.getContextPath());
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
