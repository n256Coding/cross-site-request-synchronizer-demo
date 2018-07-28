package com.n256coding.crosssiterequestsynchronizerdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping({"/home", "/"})
    public String getHomePage() {
        return "home";
    }
}
