package com.binfang.commands.reports;

import com.binfang.commands.contants.PromptConstants;
import com.binfang.commands.contants.Subjects;

import java.util.List;
import java.util.stream.Collectors;

import static com.binfang.commands.reports.DoubleFormater.formatDouble;

/**
 * Created by bfhuang on 7/27/17.
 */
public class ReportsOutputTranslator {
    public String translateReportsToString(List<Report> reports) {
        StringBuffer buffer = new StringBuffer();

        reports.forEach(report -> {

                    String students = report.getStudents().stream().map(student ->
                            String.format("%s|%s|%s|%s|%s|%s|%s",
                                    student.getName(), student.getScoreFor(Subjects.MATH),
                                    student.getScoreFor(Subjects.LANGUAGE), student.getScoreFor(Subjects.ENGLISH),
                                    student.getScoreFor(Subjects.PROGRAMMING), formatDouble(student.getAverage()),
                                    student.getTotalScore())).collect(Collectors.joining("\n"));
                    buffer.append(String.format(PromptConstants.REPORT,
                            students,
                            formatDouble(report.getClassTotalScoreAverage()),
                            formatDouble(report.getClassTotalScoreMedium())));
                }
        );

        return buffer.toString();
    }
}
