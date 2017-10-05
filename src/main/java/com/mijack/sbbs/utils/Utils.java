package com.mijack.sbbs.utils;

import java.util.regex.Pattern;

public class Utils {
    public static final Pattern PATTERN = Pattern.compile("^[a-zA-z0-9]+@[a-zA-z0-9]+(\\.[a-zA-z0-9]+)+$");

    public static boolean isEquals(String str1, String str2) {
        return str1 != null && str1.equals(str2);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }

    public static boolean isEmail(String email) {
        return PATTERN.matcher(email).matches();
    }
}
