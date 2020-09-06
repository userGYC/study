package com.project.springbootfirst.config;

import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/");
        excludePath.add("/zh-CN/login");
        excludePath.add("/en-US/login");
        excludePath.add("/zh-CN/login.html");
        excludePath.add("/en-US/login.html");
        excludePath.add("/zh-CN/loginValid");
        excludePath.add("/en-US/loginValid");
        excludePath.add("/css/**");
        excludePath.add("/imgs/**");
        excludePath.add("/js/**");
        excludePath.add("/vendor/**");
        registry.addInterceptor(new MyInterceptors()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }

  /*  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }

    *//*
     *拦截器
     *//*
    public static class MyInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String servletPath = request.getServletPath();
            if (servletPath.equals("/check")) {
                String username = (String) request.getAttribute("username");
                String password = (String) request.getAttribute("password");
                if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
                    response.sendRedirect("/index");
                }
            }
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        }
    }

    @Bean
    public ViewResolver setMyViewResolver() {
        MyViewResolver myViewResolver = new MyViewResolver();
        return myViewResolver;
    }

    *//**
     * 视图解析器
     *//*
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {

            return null;
        }
    }*/

}
