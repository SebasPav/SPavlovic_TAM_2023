package com.example.projekt_pavlovics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton mCreateRem;
    RecyclerView mRecyclerview;
    ArrayList<Model> dataholder = new ArrayList<Model>();
    //Array list to add reminders
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mCreateRem = (FloatingActionButton) findViewById(R.id.create_reminder);
        //Floating action button
        mCreateRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.projekt_pavlovics.ReminderActivity.class);
                startActivity(intent);
                //Starts the new activity for adding Reminders
            }
        });

        Cursor cursor = new com.example.projekt_pavlovics.DataBase(getApplicationContext()).readallreminders();
        //Load data From the database
        while (cursor.moveToNext()) {
            Model model = new Model(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataholder.add(model);
        }

        adapter = new MyAdapter(dataholder, MainActivity.this);
        mRecyclerview.setAdapter(adapter);
        //Binds the adapter with recyclerview

    }

    @Override
    public void onBackPressed() {
        finish();
        // exit form the app
        super.onBackPressed();

    }

}