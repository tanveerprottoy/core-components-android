package com.tanveershafeeprottoy.corecomponentssample;

import android.os.Bundle;
import android.widget.Toast;

import com.tanveershafeeprottoy.corecomponents.utils.ApplicationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationUtils.showToastMessage(
            this,
            "Hello from Core Components",
            Toast.LENGTH_SHORT
        );
    }
}