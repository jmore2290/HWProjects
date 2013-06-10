package com.muirconsult.mymadlibs;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.AsyncTask;
import android.view.View;

public class MadLibAsyncTask extends AsyncTask<String, Integer, Long>{
    public Activity act = null;
    public int thisLayout = 0;
    public String[] intextfields = null;
	@Override
	protected Long doInBackground(String... params) {
		//the following code is meant to parse XML code that is referenced by the int variable thisLayout.s
		String str =  "";
		int i = -1;
		Resources res = act.getResources();
		XmlResourceParser xpp = res.getXml(thisLayout);
		
		try {
			xpp.next();
			int eventtype = xpp.getEventType();
			while (eventtype != XmlPullParser.END_DOCUMENT){
			
				if (eventtype == XmlPullParser.START_TAG){
					if (xpp.getName() == "AutoCompleteTextView"){
						while (eventtype != XmlPullParser.END_TAG){
							xpp.next();
							if (eventtype == XmlPullParser.TEXT){
								str = xpp.getText(); // assigns string variable with value typed into AutoCompleteTextView.
								i++; // Updates the counter.
							}
						}
					}else {xpp.next();}
				}else {xpp.next();}
			    
				while (str != ""){
					intextfields[i] = str;
					
				}
				
			}
		} catch (XmlPullParserException e) {
			  e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected void onPostExecute (Long result){
		
	}
	
	

}
