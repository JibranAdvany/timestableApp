package com.example.timestablesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTable;

    public void product (int n) {


        ArrayList<String> tablesContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            tablesContent.add(Integer.toString(i * n));
        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tablesContent);
        timesTable.setAdapter(myAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTable = (ListView) findViewById(R.id.timesTable);

        // Setting seek bar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);

        // Handle the onChange on seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTable;

                if (i < min) {
                    timesTable = min;
                    seekBar.setProgress(min);
                } else {
                    timesTable = i;
                }

                product(timesTable);

                Log.i("Table Number: ", Integer.toString(timesTable));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        product(10);



    }
}