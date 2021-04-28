package com.tanveershafeeprottoy.corecomponents.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;

public class VersionUtils {

    @NonNull
    public static String getVersionName(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(
                context.getPackageName(),
                0
            ).versionName;
        }
        catch(PackageManager.NameNotFoundException n) {
            return "";
        }
    }

    public static boolean isAtLeast21() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
