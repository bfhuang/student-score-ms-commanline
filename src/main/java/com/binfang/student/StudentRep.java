package com.binfang.student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bfhuang on 7/27/17.
 */
public interface StudentRep {
    void save(Student student);

    List<Student> findByIds(List<String> ids);
}
