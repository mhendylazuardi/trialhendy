package com.example.xback.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView search_book;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_book = (ListView) findViewById(R.id.search_book);

        ArrayList<String> arrayBook = new ArrayList<>();
        arrayBook.addAll(Arrays.asList(getResources().getStringArray(R.array.list_book)));
    }
}
