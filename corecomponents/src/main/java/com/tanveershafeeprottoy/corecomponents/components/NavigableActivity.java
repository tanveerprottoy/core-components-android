package com.tanveershafeeprottoy.corecomponents.components;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Tanveer Shafee Prottoy
 */
public abstract class NavigableActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
