package com.muirconsult.mymadlibs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MovieCriticListSearch extends ListActivity {
	
	String [] movies_AtoF = new String [] {"Anonymous", "Cloverfield", "Driving Ms. Daisy", "Fargo"};
	String [] movies_GtoL = new String [] {"Green Lantern", "Inception", "Jumping The Broom", "Lincoln"};
	String [] movies_MtoR = new String [] {"Memento", "Never Back Down", "The Others", "The Prestige"};
	String [] movies_StoX = new String [] {"Silver Linings Playbook", "TItanic", "V for Vendetta", "Walking The Line"};
	String [] movies_YtoZ = new String [] {"Young Frankenstein","You Got Served","Zero Dark Thrity","Zorro"};
	String sectionChoice;
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.moviecritic_listview);
		
		ListView lv = getListView();
		Intent objIntent = getIntent();
		sectionChoice = objIntent.getStringExtra("alphabet_section"); // Intent with String extra that was sent from MovieCriticActivity
		
		if (sectionChoice.equals("Movies: A-F")){
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, 
				                                             movies_AtoF);
		lv.setAdapter(adapter);
	    }
		else if (sectionChoice.equals("Movies: G-L")){
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				                                       movies_GtoL);
		lv.setAdapter(adapter);
	    }
		else if (sectionChoice.equals("Movies: M-R")) {
	    ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,movies_MtoR);
	    lv.setAdapter(adapter);
		}
		else if (sectionChoice.equals("Movies: S-X")) {
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movies_StoX);
		lv.setAdapter(adapter);
		}
		else if (sectionChoice.equals("Movies: Y-Z")) {
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movies_YtoZ);
		lv.setAdapter(adapter);
		}
		
	
		lv.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
			 
				TextView sectionString = (TextView) view.findViewById(android.R.id.text1);
				String  valSectionString = sectionString.getText().toString();
				
				Intent intent = new Intent(getApplicationContext(), FormActivity.class);
				
				Bundle bundle = new Bundle();
				
				bundle.putString("movie_selection", valSectionString);
				intent.putExtras(bundle);
				
				startActivity(intent);
				
				
				
			}
		});
		
	}
}

