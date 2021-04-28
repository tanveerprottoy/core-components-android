package com.tanveershafeeprottoy.corecomponents.components;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentPagerAdapterBasic
    extends FragmentPagerAdapter {
    private final String[] titleArray;
    private final Fragment[] fragmentArray;

    public FragmentPagerAdapterBasic(
        FragmentManager fragmentManager,
        String[] titleArray,
        Fragment[] fragmentArray
    ) {
        super(
            fragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );
        this.titleArray = titleArray;
        this.fragmentArray = fragmentArray;
    }

    @Override
    @NonNull
    public Fragment getItem(int position) {
        return fragmentArray[position];
    }

    @Override
    public int getCount() {
        return fragmentArray.length;
    }

    @Override
    @Nullable
    public CharSequence getPageTitle(int position) {
        return titleArray[position];
    }
}
