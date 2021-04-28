package com.tanveershafeeprottoy.corecomponents.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class AnimationUtils {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void performCircularRevealAnimation(
        @NonNull View view,
        float endRadius,
        int duration,
        float interpolatorFactor,
        AnimatorListenerAdapter animatorListenerAdapter
    ) {
        circularAnimation(
            view,
            0,
            endRadius,
            duration,
            interpolatorFactor,
            animatorListenerAdapter
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void performCircularConcealAnimation(
        @NonNull View view,
        float startRadius,
        int duration,
        float interpolatorFactor,
        AnimatorListenerAdapter animatorListenerAdapter
    ) {
        circularAnimation(
            view,
            startRadius,
            0,
            duration,
            interpolatorFactor,
            animatorListenerAdapter
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void circularAnimation(
        @NonNull View view,
        float startRadius,
        float endRadius,
        int duration,
        float interpolatorFactor,
        AnimatorListenerAdapter animatorListenerAdapter
    ) {
        int centerX = view.getMeasuredWidth() / 2;
        int centerY = view.getMeasuredHeight() / 2;
        Animator animator = ViewAnimationUtils.createCircularReveal(
            view,
            centerX,
            centerY,
            startRadius,
            endRadius
        );
        animator.setDuration(duration);
        animator.setInterpolator(
            new AccelerateInterpolator(interpolatorFactor)
        );
        animator.addListener(animatorListenerAdapter);
        animator.start();
    }
}
