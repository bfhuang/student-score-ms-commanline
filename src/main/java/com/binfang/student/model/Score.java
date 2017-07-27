package com.binfang.student.model;

/**
 * Created by bfhuang on 7/27/17.
 */
public class Score {
    private final double score;
    private final String name;

    public Score(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}
