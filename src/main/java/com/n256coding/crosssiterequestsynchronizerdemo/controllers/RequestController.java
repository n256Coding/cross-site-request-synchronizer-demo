package com.n256coding.crosssiterequestsynchronizerdemo.controllers;

import com.n256coding.crosssiterequestsynchronizerdemo.models.MyData;
import com.n256coding.crosssiterequestsynchronizerdemo.models.SessionStore;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class RequestController {
    private SessionStore sessionStore = SessionStore.getInstance();

    @PostMapping("/csrf")
    public Map<String, String> getCsrfOf(@CookieValue("JSESSIONID") String sessionId) {
        return Collections.singletonMap("csrf", sessionStore.getCsrfOf(sessionId));
    }

    @PostMapping(value = "/mydata")
    public Map<String, String> setInformation(@CookieValue("JSESSIONID") String sessionId, @RequestBody MyData myData) {

        if (sessionStore.getCsrfOf(sessionId).equals(myData.csrf_token)) {
            return Collections.singletonMap("response", "success");
        } else {
            return Collections.singletonMap("response", "invalid");
        }
    }
}
