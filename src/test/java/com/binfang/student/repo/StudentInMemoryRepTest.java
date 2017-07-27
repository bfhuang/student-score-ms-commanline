package com.binfang.student.repo;

import com.binfang.student.model.Student;
import org.junit.Test;

import java.util.List;

import static com.binfang.common.StudentBuilder.buildStudent;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentInMemoryRepTest {


    @Test
    public void should_add_student_successfully() {
        StudentInMemoryRep rep = new StudentInMemoryRep();
        Student student1 = buildStudent("nam1", "1");
        Student student2 = buildStudent("nam2", "2");
        Student student3 = buildStudent("nam3", "3");
        rep.save(student1);
        rep.save(student2);
        rep.save(student3);

        List<Student> students = rep.findByIds(asList("1", "3"));

        assertThat(students, is(asList(student1, student3)));
    }
}