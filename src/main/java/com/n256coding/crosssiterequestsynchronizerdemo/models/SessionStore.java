package com.n256coding.crosssiterequestsynchronizerdemo.models;


public class SessionStore {
    private static SessionStore ourInstance = new SessionStore();

    public static SessionStore getInstance() {
        return ourInstance;
    }

    private SessionStore() {
    }
}
