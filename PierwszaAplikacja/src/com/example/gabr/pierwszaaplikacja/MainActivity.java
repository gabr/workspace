package com.example.gabr.pierwszaaplikacja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] elementy_listy = { "Własna lista",
									"Listener",
									"Linear Layout",
									"Buttons"};
		ListView prosta_lista = (ListView) findViewById(R.id.listView1);
		ArrayAdapter adapter_listy = new ArrayAdapter(this,
				android.R.layout.simple_list_item_1, elementy_listy);
		prosta_lista.setAdapter(adapter_listy);
		
		prosta_lista.setOnItemClickListener(new OnItemClickListener() {
			 
	        public void onItemClick(AdapterView arg0, View arg1, int pos,
	            long arg3) {
	 
	        switch (pos) {
	        case 0:
	            Intent startActivityCustomList = new Intent(MainActivity.this,
	                View_Custom_List.class);
	            startActivity(startActivityCustomList);
	            break;
	            
	        case 1:
	        	Intent startActivityListener = new Intent(MainActivity.this,
	        			View_Listener_Click.class);
	        	startActivity(startActivityListener);
	        	break;
	        	
	        case 2:
	        	Intent startActivityLineary = new Intent(MainActivity.this,
	        			LinearyLayout.class);
	        	startActivity(startActivityLineary);
	        	break;
	        	
	        case 3:
	        	Intent startActivityButtons = new Intent(MainActivity.this,
	        			ButtonsList.class);
	        	startActivity(startActivityButtons);
	        	break;
	        }
	 
	        }
	 
	    });
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
