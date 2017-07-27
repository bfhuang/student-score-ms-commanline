package com.binfang.printstudent;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by bfhuang on 7/27/17.
 */
public class PrintStudentInputValidatorTest {

    private PrintStudentInputValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new PrintStudentInputValidator();

    }

    @Test
    public void should_return_true_if_input_format_is_correct_with_single_student_id() {

        assertTrue(validator.validate("12"));
    }

    @Test
    public void should_return_true_if_input_format_is_correct_with_multiple_student_id() {

        assertTrue(validator.validate("12, 32, 45"));
    }

    @Test
    public void should_return_false_if_input_format_is_incorrect_with_single_student_id() {

        assertFalse(validator.validate("12 "));
    }

    @Test
    public void should_return_false_if_input_format_is_incorrect_with_multiple_student_id() {

        assertFalse(validator.validate("12, sd"));
    }
}
