package com.tanveershafeeprottoy.corecomponents.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.math.BigDecimal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;

/**
 * @author Tanveer Shafee Prottoy
 */
public class ApplicationUtils {

    public static void showToastMessage(Context context, String message, int duration) {
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public static void showAlertDialog(
        Context context,
        String title,
        String msg,
        int positiveBtnTextId,
        DialogInterface.OnClickListener onClickListener,
        boolean isCancellable
    ) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(msg)
                                        .setPositiveButton(
                                            positiveBtnTextId,
                                            onClickListener
                                        )
                                        .setCancelable(isCancellable)
                                        .create().show();
    }

    public static void showAlertDialog(
        Context context,
        String title,
        String msg,
        int positiveBtnTextId,
        int negativeBtnTextId,
        DialogInterface.OnClickListener onClickListener,
        boolean isCancellable
    ) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(msg)
                                        .setPositiveButton(
                                            positiveBtnTextId,
                                            onClickListener
                                        )
                                        .setNegativeButton(
                                            negativeBtnTextId,
                                            onClickListener
                                        )
                                        .setCancelable(isCancellable)
                                        .create().show();
    }

    public static void hideView(@NonNull View view) {
        view.setVisibility(View.GONE);
    }

    public static void showView(@NonNull View view) {
        view.setVisibility(View.VISIBLE);
    }

    public static BigDecimal convertToMonetaryValue(String value) {
        try {
            BigDecimal bigDecimal = new BigDecimal(value);
            return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        catch(NullPointerException | ArithmeticException ex) {
            return new BigDecimal("0.0");
        }
    }

    public static Uri getUriForFile(
        Context context,
        String authority,
        File file
    ) {
        return FileProvider.getUriForFile(context, authority, file);
    }

    public static int[] getScreenWidthHeight() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return new int[] { displayMetrics.widthPixels, displayMetrics.heightPixels };
    }

    public static Spannable getSpannableString(
        String text,
        int color
    ) {
        Spannable spannable = new SpannableString(text);
        spannable.setSpan(
            new ForegroundColorSpan(color),
            0,
            text.length(),
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        );
        return spannable;
    }

    public static void rateApp(
        AppCompatActivity activity
    ) {
        Uri uri = Uri.parse("market://details?id=" + activity
            .getPackageName());
        Intent goToMarket = new Intent(
            Intent.ACTION_VIEW,
            uri
        );
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
            Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            activity.startActivity(goToMarket);
        }
        catch(ActivityNotFoundException e) {
            activity.startActivity(new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    "http://play.google.com/store/apps/details?id=" + activity
                        .getPackageName())
            ));
        }
    }

    public static void shareApp(
        AppCompatActivity activity
    ) {
        ShareCompat.IntentBuilder.from(activity)
                                 .setType("text/plain")
                                 .setChooserTitle(
                                     "Share app link")
                                 .setText(
                                     "http://play.google.com/store/apps/details?id=" +
                                         activity
                                             .getPackageName())
                                 .startChooser();
    }

    public static void startActivityForClassName(
        AppCompatActivity activity,
        String packageName,
        String className
    ) {
        Intent intent = new Intent().setClassName(
            activity,
            packageName + className
        );
        activity.startActivity(intent);
    }
}
