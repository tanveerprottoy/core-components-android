package com.tanveershafeeprottoy.corecomponents.utils;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * @author Tanveer Shafee Prottoy
 */
public class ActivityUtils {
    private static FragmentTransaction fragmentTransaction;

    public static void addFragmentOnActivity(
            FragmentManager fragmentManager,
            Fragment fragment, int frameId
    ) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(frameId, fragment);
        fragmentTransaction.commit();
    }

    public static void replaceFragmentOnActivity(
            FragmentManager fragmentManager,
            Fragment fragment, int frameId,
            String name
    ) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameId, fragment);
        if(!name.equals("")) {
            fragmentTransaction.addToBackStack(name);
        }
        fragmentTransaction.commit();
    }

    public static void replaceFragmentOnActivity(
            FragmentManager fragmentManager,
            Fragment fragment, int frameId, String name,
            int enterAnim, int exitAnim, int popEnterAnim,
            int popExitAnim
    ) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        fragmentTransaction.replace(frameId, fragment);
        fragmentTransaction.addToBackStack(name);
        fragmentTransaction.commit();
    }

    public static void replaceFragmentOnActivity(
            FragmentManager fragmentManager,
            Fragment fragment, int frameId,
            String name, View view,
            String transitionName, int enterAnim, int exitAnim,
            int popEnterAnim, int popExitAnim
    ) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        fragmentTransaction.addSharedElement(view, transitionName);
        fragmentTransaction.replace(frameId, fragment);
        fragmentTransaction.addToBackStack(name);
        fragmentTransaction.commit();
    }

    public static void setToolbarTitle(@NonNull AppCompatActivity appCompatActivity, String title) {
        try {
            appCompatActivity.getSupportActionBar().setTitle(title);
        }
        catch(Exception e) {
            
        }
    }
}
