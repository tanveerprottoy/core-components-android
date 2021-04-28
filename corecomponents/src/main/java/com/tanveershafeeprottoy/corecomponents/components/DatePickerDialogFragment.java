package com.tanveershafeeprottoy.corecomponents.components;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public class DatePickerDialogFragment extends DialogFragment {
    public static final String TAG = "DatePickerDialogFragment";
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    public DatePickerDialogFragment() {
    }

    @NonNull
    public static com.biyelap.core.basecomponents.DatePickerDialogFragment newInstance() {
        return new com.biyelap.core.basecomponents.DatePickerDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);

        FragmentActivity fragmentActivity = getActivity();

        if(onDateSetListener == null) {
            throw new RuntimeException(
                "Caller of DatePickerDialogFragment must implement DatePickerDialog.OnDateSetListener"
            );
        }

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(
            fragmentActivity,
            onDateSetListener,
            year,
            month,
            dayOfMonth
        );
    }

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
    }

    /*    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof DatePickerDialog.OnDateSetListener) {
            onDateSetListener = (DatePickerDialog.OnDateSetListener) context;
        }
        else {
            throw new RuntimeException(
                "Hosting activity must implement DatePickerDialog.OnDateSetListener"
            );
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDateSetListener = null;
    }*/
}
