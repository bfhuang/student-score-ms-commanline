package com.binfang.service;

import com.binfang.service.model.Student;
import com.binfang.service.repo.StudentRep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.binfang.common.StudentBuilder.buildStudent;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock
    StudentRep studentRep;

    @InjectMocks
    private StudentService service;

    @Test
    public void should_add_student_successfully() {
        Student student = buildStudent("binfang", "1");

        service.addStudent(student);

        Mockito.verify(studentRep,times(1)).save(any(Student.class));
    }

    @Test
    public void should_get_two_student_successfully() {
        Student student1 = buildStudent("name1", "1");
        service.addStudent(student1);
        Student student2 = buildStudent("name2", "2");
        service.addStudent(student2);
        when(studentRep.findByIds(asList("1","2"))).thenReturn(asList(student1, student2));

        List<Student> students = service.getStudents(asList("1", "2"));

        assertThat(students, is(asList(student1, student2)));
        Mockito.verify(studentRep, times(1)).findByIds(asList("1", "2"));
    }

    @Test
    public void should_get_student_by_class() {
        Student student1 = buildStudent("name1", "1",3);
        service.addStudent(student1);
        Student student2 = buildStudent("name2", "2",1);
        service.addStudent(student2);
        when(studentRep.findByClassNumber(3)).thenReturn(asList(student1));

        List<Student> students = service.getStudents(3);

        assertThat(students, is(asList(student1)));
        Mockito.verify(studentRep, times(1)).findByClassNumber(3);
        Mockito.verify(studentRep, times(1)).save(student1);
        Mockito.verify(studentRep, times(1)).save(student2);

    }
}
