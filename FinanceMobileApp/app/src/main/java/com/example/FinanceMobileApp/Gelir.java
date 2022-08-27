package com.example.FinanceMobileApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Gelir extends AppCompatActivity {
    private Spinner spinner;
    private ArrayList<String> BgnList=new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir);


        spinner=findViewById(R.id.spinner);
        BgnList.add("dasda");
        BgnList.add("dasda");
        BgnList.add("dasda");
        BgnList.add("dasda");
        BgnList.add("dasda");
        BgnList.add("dasda");
        BgnList.add("dasda");

        arrayAdapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,BgnList);


        spinner.setAdapter(arrayAdapter);

    }
}