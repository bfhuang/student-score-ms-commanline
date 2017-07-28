package com.binfang.service.repo;

import com.binfang.service.model.Student;

import java.util.List;

/**
 * Created by bfhuang on 7/27/17.
 */
public interface StudentRep {
    void save(Student student);

    List<Student> findByIds(List<String> ids);

    List<Student> findByClassNumber(Integer classNumber);
}
