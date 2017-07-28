package com.binfang.service.repo;

import com.binfang.service.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by bfhuang on 7/27/17.
 */
public class StudentInMemoryRep implements StudentRep {
    private Map<String, Student> students = new HashMap<>();

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public List<Student> findByIds(List<String> ids) {
        return students.values().stream().filter(student -> ids.contains(student.getId())).collect(Collectors.toList());
    }

    @Override
    public List<Student> findByClassNumber(Integer classNumber) {
        return students.values().stream().filter(item -> item.getClassNumber() == classNumber).collect(Collectors.toList());
    }
}
