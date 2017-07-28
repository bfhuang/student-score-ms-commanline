package com.binfang.common;

import com.binfang.printstudent.Report;
import com.binfang.service.model.Student;

import java.util.List;

/**
 * Created by bfhuang on 7/27/17.
 */
public class ReportBuilder {

    public static Report buildReport(List<Student> students) {
        Report report = new Report();
        report.setClassNumber(students.get(0).getClassNumber());
        report.setStudents(students);
        report.setClassTotalScoreAverage(320);
        report.setClassTotalScoreMedium(300);

        return report;
    }
}