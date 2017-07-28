package com.binfang.commands.addstudent;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddStudentInputValidatorTest {

    private AddStudentInputValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new AddStudentInputValidator();
    }


    @Test
    public void should_return_true_if_the_add_student_input_format_is_correct() {
        boolean result = validator.validate("name22, 22, 3, 数学:21, 语文:12.5, 英语:79, 编程:93");
        assertTrue(result);

        result = validator.validate("name2, 2, 3, 数学:21, 语文:12.5, 英语:79, 编程:93");
        assertTrue(result);
    }

    @Test
    public void should_return_false_if_the_add_student_input_format_in_incorrect() {
        boolean result = validator.validate("name1, 1, 数学:21, 语文:12, 英语:79, 编程:93, dfd");

        assertFalse(result);
    }


    @Test
    public void should_return_false_if_the_class_number_start_with_0__format_is_correct() {
        boolean result = validator.validate("name1, 1, 02, 数学:21, 语文:12.5, 英语:79, 编程:93");

        assertFalse(result);
    }

}