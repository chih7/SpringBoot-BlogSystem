package com.mijack.sbbs.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({"/", "/index.html"})
    public String index() {
        return "index";
    }

    /**
     * 登录用户界面
     *
     * @return
     */
    @GetMapping({"login.html"})
    public String loginPage(Authentication authentication) {
        return (authentication != null && authentication.isAuthenticated()) ? "redirect:/" : "login";
    }

    @GetMapping({"/register.html"})
    public String register() {
        return "register";
    }
}
