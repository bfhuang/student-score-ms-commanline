package com.binfang.commands.reports;

import com.binfang.service.model.Student;

import java.util.ArrayList;
import java.util.List;

import static com.binfang.commands.reports.DoubleFormater.formatDouble;

/**
 * Created by bfhuang on 7/27/17.
 */
public class Report {
    private int classNumber;
    private List<Student> students = new ArrayList<>();
    private double classTotalScoreAverage;
    private double classTotalScoreMedium;

    public int getClassNumber() {
        return classNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setClassTotalScoreAverage(double classTotalScoreAverage) {
        this.classTotalScoreAverage = classTotalScoreAverage;
    }

    public void setClassTotalScoreMedium(double totalScoreMedium) {
        this.classTotalScoreMedium = totalScoreMedium;
    }

    public double getClassTotalScoreAverage() {
        return formatDouble(classTotalScoreAverage);
    }

    public double getClassTotalScoreMedium() {
        return formatDouble(classTotalScoreMedium);
    }
}
