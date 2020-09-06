package com.project.springbootfirst.config;


import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        Locale locale = Locale.getDefault();
        if(servletPath.contains("/")){
            String[] split = servletPath.split("/");
            if(split.length> 0){
                String str = split[1];
                if(str.contains("-")){
                    String[] split1 = str.split("-");
                    locale = new Locale(split1[0],split1[1]);
                }
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
