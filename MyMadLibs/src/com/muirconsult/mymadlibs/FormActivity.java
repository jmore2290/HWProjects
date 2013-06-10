package com.muirconsult.mymadlibs;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

public class FormActivity extends Activity{
	
	String [] textFields;
	String movieChoice;
	int thisLayout;
	Activity act = this;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent objIntent = getIntent();
		movieChoice = objIntent.getStringExtra("movie_selection");
		
		if (movieChoice.equals("Cloverfield")) {
			setContentView(R.layout.cloverfield_in);
			thisLayout = (R.layout.cloverfield_in);
		}
		
		
	}
	
	
	
	public void onClick(View view) {
	/* trying to devise way that is friendly to the main UI thread...to parse XML tht is contained in the 
	 * current layout (thisLayout), obtain text contained within AutoCompleteTextView tags in the XML code
	 * and the resulting text to another layout file. However, calling this method (which is done when
	 * pressing a button on the layout) results in a error: thread existing with uncaught exception.
	 */
		MadLibAsyncTask mad = new MadLibAsyncTask();
		mad.intextfields = textFields;
		mad.act = act;
		mad.thisLayout = thisLayout;
		mad.execute();
		
		
		setContentView(R.layout.cloverfield_out);
		TextView outview = (TextView)findViewById(R.id.outview);
		
		outview.setText(textFields[0]);
	}

}
