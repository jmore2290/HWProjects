package com.muirconsult.mymadlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MovieCriticActivity extends Activity{

	String[] list_movies = new String[] {"Movies: A-F", "Movies: G-L", "Movies: M-R",
			     "Movies: S-X", "Movies: Y-Z"};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.movie_critic_main_page); // Layout for the movie critic madlib section
		
		ListView movielist = (ListView)findViewById(R.id.list);  // this listview on the layout is populated with choices from the string array list_movies
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				       android.R.layout.simple_list_item_1, list_movies);  
		
		movielist.setAdapter(adapter);
		
		movielist.setOnItemClickListener(new OnItemClickListener() {                  // this onItemClickListener launches MovieCriticListSearch.class which is where movies in the selected alphabet range are displayed.
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getApplicationContext(), MovieCriticListSearch.class);
				
				Bundle mybundle = new Bundle();
				
				mybundle.putString("alphabet_section", list_movies[position]);
				intent.putExtras(mybundle);
				
				startActivity(intent);
				
				
			}

		});
		
	}
}
