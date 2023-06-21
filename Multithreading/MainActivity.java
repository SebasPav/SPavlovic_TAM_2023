package com.example.multithreading;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	@SuppressLint("SetTextI18n")

	public void startNewThread() {
		Thread myThread = new Thread(new Runnable() {
			@Override
			public void run() {

				TextView tv1 = findViewById(R.id.tv1);
				TextView tv2 = findViewById(R.id.tv2);
				TextView tv3 = findViewById(R.id.tv3);

				for (int i = 0; i < 5; i++) {
					Log.d("MyThread", "Doing work in new thread: " + i);

					try {
						tv1.setText("Stopped1");
						tv2.setText("Started2");
						tv3.setText("Stopped3");
						Thread.sleep(1000);
						tv1.setText("Started1");
						tv2.setText("Stopped2");
						tv3.setText("Started3");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		myThread.start();
	}

	public void startAnotherThread() {
		Thread myThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					Log.d("MyThread", "Doing work in new thread: " + i*10);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		myThread.start();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startNewThread();
		startAnotherThread();
	}
}