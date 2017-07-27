package com.binfang.student;

import com.binfang.student.model.Student;
import com.binfang.student.repo.StudentRep;

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
