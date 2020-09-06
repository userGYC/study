package com.project.springbootfirst.config;


import com.project.springbootfirst.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            String servletPath = request.getServletPath();
            String language = null;
            if (servletPath.contains("/")) {
                String[] split = servletPath.split("/");
                language = split[1];
            }
            request.getSession().setAttribute("msg", "没有登录，请先登录！");
            //request.getRequestDispatcher("login").forward(request,response);
            response.sendRedirect("/" + language + "/login");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
