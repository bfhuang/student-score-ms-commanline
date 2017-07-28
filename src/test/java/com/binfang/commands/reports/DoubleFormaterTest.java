package com.binfang.commands.reports;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class DoubleFormaterTest {

    @Test
    public void should_return_double_contains_two_digits_after_dot() {
        double result = DoubleFormater.formatDouble(12.33333);

        assertThat(result, is(12.33));
    }

    @Test
    public void should_return_ran_upped_double() {
        double result = DoubleFormater.formatDouble(12.33533);

        assertThat(result, is(12.34));
    }

    @Test
    public void should_return_the_input_itself_if_ther_is_not_more_than_2_digits_after_dot() {
        double result = DoubleFormater.formatDouble(12.0);

        assertThat(result, is(12.0));
    }
}