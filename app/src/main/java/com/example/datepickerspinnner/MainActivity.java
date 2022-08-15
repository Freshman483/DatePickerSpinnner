package com.example.datepickerspinnner;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePickerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePickerSpinner = findViewById(R.id.date_picker);

        Calendar calendar = Calendar.getInstance();

        datePickerSpinner.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                        month += 1;

                        String date_selected = year + "/" + month + "/" + day;

                        TextView textView = findViewById(R.id.dateDisplay);
                        textView.setText(date_selected);
                        Toast.makeText(MainActivity.this, "Date: " + date_selected, Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}