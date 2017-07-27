package com.binfang.addstudent;

import java.util.regex.Pattern;

public class AddStudentInputValidator {

    private static final String ADD_STUDENT_INPUT_REGEX = "^(.+),\\s([\\d+]),\\s[1-9]d*,\\s数学:((\\d+\\.\\d+)|(\\d+))" +
            ",\\s语文:((\\d+\\.\\d+)|(\\d+)),\\s英语:((\\d+\\.\\d+)|(\\d+)),\\s编程:((\\d+\\.\\d+)|(\\d+))$";

    public boolean validate(String input) {
        return Pattern.compile(ADD_STUDENT_INPUT_REGEX).matcher(input).matches();
    }
}
