package com.example.gabr.pierwszaaplikacja;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] elementy_listy = { "Element 1",
									"Element 2",
									"Element 3"};
		ListView prosta_lista = (ListView) findViewById(R.id.listView1);
		ArrayAdapter adapter_listy = new ArrayAdapter(this,
				android.R.layout.simple_list_item_1, elementy_listy);
		prosta_lista.setAdapter(adapter_listy);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
