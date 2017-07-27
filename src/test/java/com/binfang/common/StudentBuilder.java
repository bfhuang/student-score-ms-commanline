package com.binfang.common;

import com.binfang.student.Score;
import com.binfang.student.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentBuilder {

    public static Student buildStudent(String name, String id) {
        Student student = new Student();
        List<Score> scores = Arrays.asList(
                new Score("数学", 80.5),
                new Score("英语", (double) 92),
                new Score("编程", 93.5),
                new Score("语文", 92.5)
        );


        student.setName(name);
        student.setId(id);
        student.setScores(scores);
        return student;
    }
}
