package com.example.gabr.pierwszaaplikacja;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class View_Custom_List extends Activity {
	
	@Override
	protected void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView rozbudowana_lista = (ListView) findViewById(R.id.listView1);
		String[] dane = {"aaaaa",
						 "bbbbb",
						 "ccccc",
						 "ddddd"};
		List_Custom_List adapter_listy = new List_Custom_List(this, dane);
		rozbudowana_lista.setAdapter(adapter_listy);
		
	}

}
