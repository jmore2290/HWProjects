package com.example.flashapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;

public class FlashReal extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_flash);
	    
	    String[] characters = new String[] {
	    		"Joffrey Baratheon", "Jamie Lannister", "Daenerys Targaryen", "Tyrion Lannister","Sansa Stark"
	    };
	    
	    ListView gotCharacters = (ListView)findViewById(R.id.listGotCharacters);
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, characters);
	    gotCharacters.setAdapter(adapter);
	}
}
