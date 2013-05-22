package com.muirconsult.mymadlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



public class MadFlashActivity2 extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mad_flash_page);
		
		int secondsDelayed = 1;
		new Handler().postDelayed(new Runnable() {
			   public void run() {
				   startActivity(new Intent(MadFlashActivity2.this, MainMadLibActivity.class));
			   }
		}, secondsDelayed * 1000);
	}

}
