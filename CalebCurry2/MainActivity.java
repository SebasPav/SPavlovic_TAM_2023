package com.example.calebcurry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main");
    }

    public void disable (View v){
        v.setEnabled(false);
        Button button = (Button) v;
        button.setText("Knopka");
        Toast.makeText(this, "ERROR isn't here!", Toast.LENGTH_LONG).show();
    }

    public void handleText(View v) {
        TextView t = findViewById(R.id.textSource);
        String input = t.getText().toString();
        Button b = (Button) v;
        b.setText(input);
        ((TextView)findViewById(R.id.helloWorld)).setText(input);
        Log.d("info", input);
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

    public void launchSettings(View v){
        // launch a new activity
        Intent i = new Intent(this, SettingsActivity.class);
        String message = ((EditText)findViewById(R.id.textSource)).getText().toString();
        i.putExtra("COOL", message);
        startActivity(i);
    }
}