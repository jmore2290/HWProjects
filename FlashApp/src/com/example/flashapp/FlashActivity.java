package com.example.flashapp;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class FlashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		class MyTimerTask extends TimerTask {
			public void  run(){
			Intent intent = new Intent(getApplicationContext(), FlashReal.class);
			startActivity(intent);
			}	
		}
		
		MyTimerTask myTask = new MyTimerTask();
		Timer myTimer = new Timer();
		
		myTimer.schedule(myTask, 3000, 1500);
		setContentView(R.layout.real_flash);
		
		
		
	}

	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flash, menu);
		return true;
	}

}
