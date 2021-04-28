package com.tanveershafeeprottoy.corecomponents.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

public class PermissionUtils {
    public static final int PERMISSION_GRANTED_CODE = PackageManager.PERMISSION_GRANTED;

    public static boolean isPermissionGranted(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PERMISSION_GRANTED_CODE;
    }

    public static boolean[] arePermissionsGranted(Context context, String[] permissions) {
        int length = permissions.length;
        boolean[] grants = new boolean[length];
        for(int i = 0; i < length; i++) {
            grants[i] = ContextCompat.checkSelfPermission(
                context,
                permissions[i]
            ) == PERMISSION_GRANTED_CODE;
        }
        return grants;
    }
}
