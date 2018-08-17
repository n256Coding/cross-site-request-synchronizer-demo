package com.n256coding.crosssiterequestsynchronizerdemo.controllers;

import com.n256coding.crosssiterequestsynchronizerdemo.models.DataStore;
import com.n256coding.crosssiterequestsynchronizerdemo.models.MyData;
import com.n256coding.crosssiterequestsynchronizerdemo.models.SessionStore;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

@RestController
public class RequestController {
    private SessionStore sessionStore = SessionStore.getInstance();
    private DataStore dataStore = DataStore.getInstance();

    @PostMapping("/csrf")
    public Map<String, String> getCsrfOf(@CookieValue("JSESSIONID") String sessionId) {
        return Collections.singletonMap("csrf", sessionStore.getCsrfOf(sessionId));
    }

    @PostMapping(value = "/mydata")
    public Map<String, String> setInformation(@CookieValue("JSESSIONID") String sessionId,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
        String csrfToken = request.getParameter("csrf_token");
        String accountNumber = request.getParameter("receiver_account_number");
        double value = Double.parseDouble(request.getParameter("value"));

        if(csrfToken == null || !sessionStore.getCsrfOf(sessionId).equals(csrfToken)){
            response.setStatus(403);
            return Collections.singletonMap("response", "forbidden");
        }
        else if(sessionStore.getCsrfOf(sessionId).equals(csrfToken)){
            response.setStatus(200);
            return Collections.singletonMap("response", "success");
        }
        else{
            return Collections.singletonMap("response", "forbidden");
        }
    }

    @GetMapping(value = "/transactions")
    public HashSet<MyData> getAllRequests(){
        return dataStore.getRequests();
    }
}
