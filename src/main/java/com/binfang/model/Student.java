package com.binfang.model;

import java.util.Map;

/**
 * Created by bfhuang on 7/27/17.
 */
public class Student {
    private String name;
    private String id;
    private Map<String, Double> scores;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    public String getId() {
        return id;
    }
}
