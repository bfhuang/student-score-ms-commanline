package com.binfang.student.repo;

import com.binfang.student.model.Student;

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
        return ids.stream().map(id -> students.get(id)).collect(Collectors.toList());
    }
}
