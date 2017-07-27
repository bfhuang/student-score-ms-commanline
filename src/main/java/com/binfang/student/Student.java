package com.binfang.student;

import java.util.List;

/**
 * Created by bfhuang on 7/27/17.
 */
public class Student {
    private String name;
    private String id;
    private List<Score> scores;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Score> getScores() {
        return scores;
    }
}
