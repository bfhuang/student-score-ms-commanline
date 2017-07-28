package com.binfang.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bfhuang on 7/27/17.
 */
public class Student {
    private String name;
    private String id;
    private List<Score> scores = new ArrayList<>();
    private int classNumber;

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

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public double getTotalScore() {
        return scores.stream().mapToDouble(score -> score.getScore()).sum();
    }

    public double getScoreFor(String subject) {
        for (Score score : scores) {
            if (subject.equals(score.getName()))
                return score.getScore();
        }

        return 0;
    }

    public double getAverage() {
        return scores.stream().mapToDouble(item -> item.getScore()).average().getAsDouble();
    }
}
