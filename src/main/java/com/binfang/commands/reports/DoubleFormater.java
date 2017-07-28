package com.binfang.commands.reports;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * Created by bfhuang on 7/27/17.
 */
public interface DoubleFormater {

    String DOUBLE_HAS_MORE_THAN_TWO_DIGITS_AFTER_DOT = "^\\d+\\.\\d{3,}$";
    String DOUBLE_ONLY_HAS_0_AFTER_DOT = "^\\d+\\.0$";

    static String formatDouble(double input) {
        if (Pattern.compile(DOUBLE_HAS_MORE_THAN_TWO_DIGITS_AFTER_DOT).matcher(String.valueOf(input)).matches()) {
            BigDecimal bd = new BigDecimal(input);
            return String.valueOf(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }else if(Pattern.compile(DOUBLE_ONLY_HAS_0_AFTER_DOT).matcher(String.valueOf(input)).matches()){
            DecimalFormat df = new DecimalFormat("###");
            return df.format(input);
        }

        return String.valueOf(input);
    }
}
