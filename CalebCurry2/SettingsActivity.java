package com.example.calebcurry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent i = getIntent();
        String message = i.getStringExtra("COOL");
        ((TextView)findViewById(R.id.textView)).setText(message);
    }

    public void launchMain(View v){
        // launch a new activity

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}