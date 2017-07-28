package com.binfang.commands.reports;

import org.junit.Test;

import java.text.DecimalFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class DoubleFormaterTest {

    @Test
    public void should_return_double_contains_two_digits_after_dot() {
        String result = DoubleFormater.formatDouble(12.33333);

        assertThat(result, is("12.33"));
    }

    @Test
    public void should_return_ran_upped_double() {
        String result = DoubleFormater.formatDouble(12.33533);

        assertThat(result, is("12.34"));
    }

    @Test
    public void should_return_the_removed_dot_0() {
        String result = DoubleFormater.formatDouble(12.0);

        assertThat(result, is("12"));
    }

    @Test
    public void should_return_the_number_self_if_there_is_one_non_0_digit_after_dot() {
        String result = DoubleFormater.formatDouble(12.3);

        assertThat(result, is("12.3"));
    }

    @Test
    public void should_return_the_number_self_if_there_is_two_non_0_digit_after_dot() {
        String result = DoubleFormater.formatDouble(12.34);

        assertThat(result, is("12.34"));
    }
}