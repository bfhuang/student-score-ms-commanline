package com.binfang.student;

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
}
