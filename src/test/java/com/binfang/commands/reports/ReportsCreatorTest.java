package com.binfang.commands.reports;

import com.binfang.service.StudentService;
import com.binfang.service.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.binfang.helper.StudentBuilder.buildStudent;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by bfhuang on 7/27/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class ReportsCreatorTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    ReportsCreator builder;

    @Test
    public void should_return_empty_reports_when_student_id_does_not_exist() {
        List<String> ids = asList("1");
        when(studentService.getStudents(ids)).thenReturn(new ArrayList<Student>());

        List<Report> reports = builder.buildReports(ids);

        assertThat(reports.size(), is(0));
    }

    @Test
    public void should_return_reports_with_one_report_when_only_one_student_exist() {
        List<String> ids = asList("1", "2");
        when(studentService.getStudents(ids)).thenReturn(asList(buildStudent("name1", "1", 3)));
        List<Student> studentsOfClass = asList(buildStudent("name1", "1", 3, 1),
                buildStudent("name2", "2", 3, 2), buildStudent("name3", "3", 3, 3),
                buildStudent("name4", "4", 3, 5));
        when(studentService.getStudents(3)).thenReturn(
                studentsOfClass).thenReturn(studentsOfClass);

        List<Report> reports = builder.buildReports(ids);

        assertThat(reports.size(), is(1));
        assertThat(reports.get(0).getClassNumber(), is(3));
        assertThat(reports.get(0).getStudents().size(), is(1));
        assertThat(reports.get(0).getStudents().get(0).getId(), is("1"));
        assertThat(reports.get(0).getStudents().get(0).getName(), is("name1"));
        assertThat(reports.get(0).getClassTotalScoreAverage(), is(11.0));
        assertThat(reports.get(0).getClassTotalScoreMedium(), is(10.0));
    }

    @Test
    public void should_return_reports_with_two_report_when_only_two_student_exist_with_different_class() {
        List<String> ids = asList("1", "2");
        when(studentService.getStudents(ids)).thenReturn(
                asList(buildStudent("name1", "1", 3), buildStudent("name2", "2", 2)));

        List<Student> studentsOfClass3 = asList(buildStudent("name1", "1", 3, 70),
                buildStudent("name3", "3", 3, 80));
        when(studentService.getStudents(3)).thenReturn(
                studentsOfClass3).thenReturn(studentsOfClass3);


        List<Student> studentsOfClass2 = asList(buildStudent("name2", "2", 2, 75),
                buildStudent("name4", "4", 2, 80), buildStudent("name5", "5", 2, 90));
        when(studentService.getStudents(2)).thenReturn(
                studentsOfClass2).thenReturn(studentsOfClass2);

        List<Report> reports = builder.buildReports(ids);

        assertThat(reports.size(), is(2));
        assertThat(reports.get(0).getClassNumber(), is(2));
        assertThat(reports.get(0).getStudents().size(), is(1));
        assertThat(reports.get(0).getStudents().get(0).getId(), is("2"));
        assertThat(reports.get(0).getStudents().get(0).getName(), is("name2"));
        assertThat(reports.get(0).getClassTotalScoreAverage(), is(326.6666666666667));
        assertThat(reports.get(0).getClassTotalScoreMedium(), is(320.0));
    }
}
