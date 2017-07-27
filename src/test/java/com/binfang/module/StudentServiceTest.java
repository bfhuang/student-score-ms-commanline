package com.binfang.module;

import com.binfang.model.Student;
import com.bing.module.StudentService;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentServiceTest {

    private StudentService service;


    @Before
    public void setUp() throws Exception {
        service = new StudentService();
    }

    @Test
    public void should_add_student_successfully() {
        service = new StudentService();
        Student student = buildStudent("binfang", "1");

        service.addStudent(student);

        assertThat(service.getStudents(asList("1")), is(asList(student)));
    }

    @Test
    public void should_get_two_student_successfully() {
        Student student1 = buildStudent("name1", "1");
        service.addStudent(student1);
        Student student2 = buildStudent("name2", "2");
        service.addStudent(student2);

        List<Student> students = service.getStudents(asList("1", "2"));

        assertThat(students, is(asList(student1, student2)));
    }

    private Student buildStudent(String name, String id) {
        Student student = new Student();
        Map<String, Double> scores = ImmutableMap.of(
                "数学", (double) 90,
                "英语", (double) 92,
                "编程", 92.3,
                "语文", (double) 91);

        student.setName(name);
        student.setId(id);
        student.setScores(scores);
        return student;
    }

}
