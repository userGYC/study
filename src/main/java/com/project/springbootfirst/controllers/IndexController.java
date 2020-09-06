package com.project.springbootfirst.controllers;

import com.project.springbootfirst.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String first(Model model) {
        model.addAttribute("lang", "zh-CN");
        return "login";
    }

    @RequestMapping(value = "/{language}/login", method = RequestMethod.GET)
    public String login(@PathVariable String language, Model model) {
        model.addAttribute("lang", language);
        return "login";
    }

    @RequestMapping(value = "/{language}/loginValid", method = RequestMethod.POST)
    public String onLogin(@PathVariable String language, Model model, User user, HttpSession session) {
        model.addAttribute("lang",language);
        if (user != null && "123456".equals(user.getPassword())) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "redirect:index.html";
        }
        model.addAttribute("msg", "用户名或密码有误，请重新输入");
        return "login";
    }

    @RequestMapping(value = {"/{language}/index", "/{language}/index.html"}, method = RequestMethod.GET)
    public String index(@PathVariable("language") String lang, Model model) {
        model.addAttribute("lang", lang);
        return "index";
    }
}
