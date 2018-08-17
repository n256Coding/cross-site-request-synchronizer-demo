package com.n256coding.crosssiterequestsynchronizerdemo.models;

import java.util.HashSet;

public class DataStore {
    private static DataStore ourInstance = new DataStore();
    private HashSet<MyData> requests = new HashSet<>();

    public static DataStore getInstance() {
        return ourInstance;
    }

    private DataStore() {
    }

    public void setRequest(MyData data){
        this.requests.add(data);
    }

    public HashSet<MyData> getRequests(){
        return this.requests;
    }
}
