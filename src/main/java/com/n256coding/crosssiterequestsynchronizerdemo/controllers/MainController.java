package com.n256coding.crosssiterequestsynchronizerdemo.controllers;

import com.n256coding.crosssiterequestsynchronizerdemo.models.SessionStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    private SessionStore sessionStore = SessionStore.getInstance();

    @GetMapping("/login")
    public String getLoginPage(Principal user) {
        if (user != null) {
            return "redirect: ";
        }
        return "login";
    }

    @GetMapping({"/home", "/"})
    public String getHomePage() {
        return "home";
    }
}
