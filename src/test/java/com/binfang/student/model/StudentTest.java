package com.binfang.student.model;

import com.binfang.common.StudentBuilder;
import com.binfang.common.Subjects;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentTest {

    @Test
    public void should_get_score_for_subject() {
        Student student = StudentBuilder.buildStudent("name1", "1", 3, 90);

        double score = student.getScoreFor(Subjects.MATH);

        Assert.assertThat(score, is(90.0));
    }

    @Test
    public void should_get_average_score() {
        Student student = StudentBuilder.buildStudent("name1", "1", 3, 90);

        double score = student.getAverage();

        Assert.assertThat(score, is(90.0));
    }

    @Test
    public void should_not_get_score_for_not_exist_subject() {
        Student student = StudentBuilder.buildStudent("name1", "1", 3, 90);

        double score = student.getScoreFor("notExist");

        Assert.assertThat(score, is(0.0));
    }
}