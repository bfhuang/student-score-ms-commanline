package com.binfang.printstudent;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * Created by bfhuang on 7/27/17.
 */
public interface DoubleFormater {

    String DOUBLE_HAS_MORE_THAN_TWO_DIGITS_AFTER_DOT = "^\\d+\\.\\d{3,}$";

    static double formatDouble(double input) {
        if (Pattern.compile(DOUBLE_HAS_MORE_THAN_TWO_DIGITS_AFTER_DOT).matcher(String.valueOf(input)).matches()) {
            BigDecimal bd = new BigDecimal(input);
            return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        return input;
    }
}
