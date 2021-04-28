package com.tanveershafeeprottoy.corecomponents.utils;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * @author Tanveer Shafee Prottoy
 */
public class ValidationUtils {

    public static boolean isValidString(String string) {
        return !TextUtils.isEmpty(string);
    }

    public static boolean areValidStrings(String... strings) {
        for(String string : strings) {
            if(TextUtils.isEmpty(string)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidInteger(String integer) {
        try {
            return Integer.parseInt(integer) >= 0;
        }
        catch(NumberFormatException n) {
            return false;
        }
    }

    public static boolean isValidDouble(String doubleValue) {
        try {
            return Double.parseDouble(doubleValue) >= 0D;
        }
        catch(NumberFormatException n) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }
}
