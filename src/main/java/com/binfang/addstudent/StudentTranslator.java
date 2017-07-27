package com.binfang.addstudent;

import com.binfang.student.Score;
import com.binfang.student.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentTranslator {

    public Student buildStudent(String input) {
        String[] split = input.split(",\\s");
        Student student = new Student();
        student.setName(split[0]);
        student.setId(split[1]);
        List<Score> scores = Stream.of(split).filter(item -> item.contains(":")).map(
                item -> {
                    String[] scoreSplit = item.split(":");
                    return new Score(scoreSplit[0], Double.parseDouble(scoreSplit[1]));
                }).collect(Collectors.toList());
        student.setScores(scores);

        return student;
    }

}
