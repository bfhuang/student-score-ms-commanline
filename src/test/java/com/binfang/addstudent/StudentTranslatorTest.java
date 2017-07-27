package com.binfang.addstudent;

import com.binfang.student.Student;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentTranslatorTest {

    @Test
    public void should_build_student_successfully() {
        StudentTranslator builder = new StudentTranslator();

        Student student = builder.buildStudent("name1, 1, 数学:90.5, 语文:12, 英语:79, 编程:93");

        assertThat(student.getId(), is("1"));
        assertThat(student.getName(), is("name1"));
        assertThat(student.getScores().size(), is(4));
    }
}