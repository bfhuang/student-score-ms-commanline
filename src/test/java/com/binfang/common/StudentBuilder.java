package com.binfang.common;

import com.binfang.service.model.Score;
import com.binfang.service.model.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentBuilder {

    public static Student buildStudent(String name, String id) {
        return buildStudent(name, id, 3, 90.5);
    }

    public static Student buildStudent(String name, String id, int classNumber) {
        return buildStudent(name, id, classNumber, 90.5);
    }

    public static Student buildStudent(String name, String id, int classNumber, double score) {
        Student student = new Student();
        List<Score> scores = Arrays.asList(
                new Score("数学", score),
                new Score("英语", score),
                new Score("编程", score),
                new Score("语文", score)
        );

        student.setClassNumber(classNumber);
        student.setName(name);
        student.setId(id);
        student.setScores(scores);
        return student;
    }

}
