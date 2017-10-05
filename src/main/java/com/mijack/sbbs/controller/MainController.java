package com.mijack.sbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({"/", "/index.html"})
    public String index() {
        return "index";
    }

    @GetMapping({"/login.html"})
    public String login() {
        return "login";
    }

    @GetMapping({"/register.html"})
    public String register() {
        return "register";
    }
}
