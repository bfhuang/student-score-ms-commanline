package com.binfang.printstudent;

import com.binfang.service.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.binfang.common.ReportBuilder.buildReport;
import static com.binfang.common.StudentBuilder.buildStudent;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class ReportsOutputTranslatorTest {

    private ReportsOutputTranslator translator;

    @Before
    public void setUp() throws Exception {
        translator = new ReportsOutputTranslator();
    }

    @Test
    public void should_translator_reports_to_string_when_there_is_only_one_report() {
        List<Student> students = asList(buildStudent("name1", "1", 1, 80));

        String result = translator.translateReportsToString(asList(buildReport(students)));

        assertThat(result, is("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "name1|80.0|80.0|80.0|80.0|80.0|320.0\n" +
                "========================\n" +
                "全班总分平均数：320.0\n" +
                "全班总分中位数：300.0\n"));

    }

    @Test
    public void should_translator_reports_to_string_when_there_is_only_two_report() {
        List<Student> students = asList(buildStudent("name1", "1", 1, 80));
        List<Student> students2 = asList(buildStudent("name2", "2", 1, 70));

        String result = translator.translateReportsToString(asList(buildReport(students), buildReport(students2)));

        assertThat(result, is("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "name1|80.0|80.0|80.0|80.0|80.0|320.0\n" +
                "========================\n" +
                "全班总分平均数：320.0\n" +
                "全班总分中位数：300.0\n" +
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "name2|70.0|70.0|70.0|70.0|70.0|280.0\n" +
                "========================\n" +
                "全班总分平均数：320.0\n" +
                "全班总分中位数：300.0\n"));

    }
}
