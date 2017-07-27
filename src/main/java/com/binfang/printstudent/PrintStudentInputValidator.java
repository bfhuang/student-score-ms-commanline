package com.binfang.printstudent;

import java.util.regex.Pattern;

/**
 * Created by bfhuang on 7/27/17.
 */
public class PrintStudentInputValidator {

    private static final String PRINT_STUDENTS_INPUT_REGEX = "^((\\d+,\\s)+\\d+)|(\\d+)$";

    public boolean validate(String input) {
        return Pattern.compile(PRINT_STUDENTS_INPUT_REGEX).matcher(input).matches();
    }
}
