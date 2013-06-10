package com.muirconsult.mymadlibs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainMadLibActivity extends Activity {


	final Context context = this;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main_mad_lib);
		
	}
	
	public void onClickMovieCritic(View view){
		Intent i = new Intent(context, MovieCriticActivity.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_mad_lib, menu);
		return true;
	}

}
