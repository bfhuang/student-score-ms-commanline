package com.binfang.service;

import com.binfang.service.model.Student;
import com.binfang.service.repo.StudentRep;

import java.util.List;

public class StudentService {
    private final StudentRep studentRep;

    public StudentService(StudentRep rep) {
        this.studentRep = rep;
    }

    public void addStudent(Student student) {
        studentRep.save(student);
    }

    public List<Student> getStudents(List<String> ids) {
        return studentRep.findByIds(ids);
    }

    public List<Student> getStudents(Integer classNumber) {
        return studentRep.findByClassNumber(classNumber);
    }
}
