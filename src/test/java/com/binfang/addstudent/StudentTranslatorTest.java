package com.binfang.addstudent;

import com.binfang.student.model.Score;
import com.binfang.student.model.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentTranslatorTest {

    @Test
    public void should_build_student_successfully() {
        StudentTranslator builder = new StudentTranslator();
        List<Score> scores = Arrays.asList(
                new Score("数学", 90.5),
                new Score("语文", 12),
                new Score("英语", 79),
                new Score("编程", 93)
        );

        Student student = builder.buildStudent("name1, 1, 3, 数学:90.5, 语文:12, 英语:79, 编程:93");

        assertThat(student.getId(), is("1"));
        assertThat(student.getSubject(), is("name1"));
        assertThat(student.getScores().size(), is(4));
        assertThat(student.getScores().get(0).getName(), is("数学"));
        assertThat(student.getScores().get(0).getScore(), is(90.5));
        assertThat(student.getClassNumber(), is(3));
    }
}