package com.n256coding.crosssiterequestsynchronizerdemo.models;


import java.util.HashMap;
import java.util.UUID;

public class SessionStore {
    private static SessionStore ourInstance = new SessionStore();
    private HashMap<String, String> sessionIds = new HashMap<>();

    public static SessionStore getInstance() {
        return ourInstance;
    }

    private SessionStore() {
    }

    public String getCsrfOf(String sessionId) {
        return sessionIds.get(sessionId);
    }

    public void newSession(String sessionId){
        String csrf = UUID.randomUUID().toString();
        this.sessionIds.put(sessionId, csrf);
    }

    public HashMap<String, String> getHashMap(){
        return sessionIds;
    }
}
