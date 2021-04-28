package com.tanveershafeeprottoy.corecomponents.utils;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class IntentUtils {

    public static Intent createImplicitIntent(
        String action,
        String type
    ) {
        try {
            Intent intent = new Intent(action);
            if(type != null) {
                intent.setType(type);
            }
            return intent;
        }
        catch(ActivityNotFoundException a) {
            return null;
        }
    }

    public static Intent createImplicitIntent(
        String action,
        Uri uri,
        String type
    ) {
        try {
            Intent intent = new Intent(action, uri);
            if(type != null) {
                intent.setType(type);
            }
            return intent;
        }
        catch(ActivityNotFoundException a) {
            return null;
        }
    }

    public static Intent createCameraIntent(
        Context context,
        Uri outputUri,
        String label  //photo
    ) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        else {
            ClipData clip = ClipData.newUri(
                context.getContentResolver(),
                label,
                outputUri
            );
            intent.setClipData(clip);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        return intent;
    }

    public static Intent createEmailIntent(
        @NonNull AppCompatActivity appCompatActivity,
        String[] addressArray
    ) {
        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addressArray);
            return intent;
        }
        catch(ActivityNotFoundException a) {
            return null;
        }
    }

    public static Intent createChooserIntent(
        String action,
        String type,
        String title,
        Intent initialIntent
    ) {
        try {
            Intent chooser = Intent.createChooser(
                createImplicitIntent(
                    action,
                    type
                ),
                title
            );
            chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] { initialIntent });
            return chooser;
        }
        catch(ActivityNotFoundException a) {
            return null;
        }
    }
}
