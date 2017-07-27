package com.binfang.printstudent;

import com.binfang.student.StudentService;
import com.binfang.student.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportsCreator {
    private final StudentService studentService;

    public ReportsCreator(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Report> buildReports(List<String> ids) {
        List<Report> reports = new ArrayList<>();
        List<Student> students = studentService.getStudents(ids);

        if (students.size() != 0) {
            Map<Integer, List<Student>> groupedStudents = getGroupedStudentsByClass(students);
            reports = mapGroupedStudentsToReportList(groupedStudents);
            generateClassTotalScoreAverage(reports);
            generateClassTotalScoreMedium(reports);
        }


        return reports;
    }

    private void generateClassTotalScoreMedium(List<Report> reports) {
        reports.forEach(report -> {
            List<Double> sortedStudentTotalScores = studentService.getStudents(report.getClassNumber()).stream()
                    .mapToDouble(student -> student.getTotalScore()).sorted().boxed().collect(Collectors.toList());
            int count = sortedStudentTotalScores.size();

            report.setClassTotalScoreMedium(count % 2 == 1 ?
                    sortedStudentTotalScores.get(count / 2) :
                    (sortedStudentTotalScores.get(count / 2) + sortedStudentTotalScores.get(count / 2 - 1)) / 2);
        });
    }

    private void generateClassTotalScoreAverage(List<Report> reports) {
        reports.forEach(report -> {
            report.setClassTotalScoreAverage(studentService.getStudents(report.getClassNumber()).stream()
                    .mapToDouble(student -> student.getTotalScore()).average().getAsDouble());
        });
    }

    private List<Report> mapGroupedStudentsToReportList(Map<Integer, List<Student>> groupedStudents) {
        List<Report> reports;
        reports = groupedStudents.keySet().stream().map(key -> {
            Report report = new Report();
            report.setClassNumber(key);
            report.setStudents(groupedStudents.get(key));
            return report;
        }).collect(Collectors.toList());
        return reports;
    }

    private Map<Integer, List<Student>> getGroupedStudentsByClass(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getClassNumber));
    }
}
