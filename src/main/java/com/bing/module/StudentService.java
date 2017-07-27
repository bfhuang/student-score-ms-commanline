package com.bing.module;

import com.binfang.model.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        this.students.put(student.getId(), student);

    }

    public List<Student> getStudents(List<String> ids) {
        return ids.stream().map(id -> students.get(id)).collect(Collectors.toList());
    }
}
