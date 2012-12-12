package com.example.gabr.pierwszaaplikacja;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class View_Listener_Click extends Activity implements OnClickListener {
	
	TextView	text;
	ImageView	image;
	Button		button;
	
	@Override
	protected void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		setContentView(R.layout.view_listener_click);
		
		text = (TextView) findViewById(R.id.textViewListener1);
		image = (ImageView) findViewById(R.id.imageViewListener1);
		button = (Button) findViewById(R.id.buttonListener1);
		
		text.setOnClickListener(this);
		button.setOnClickListener(this);
		
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				v.setVisibility(View.GONE);
			}
		});
	}
	
	public void onClick(View v) {
		
		switch(v.getId()) {
		case R.id.buttonListener1:
			Intent startMainActitivity= new Intent(View_Listener_Click.this,
        			MainActivity.class);
        	startActivity(startMainActitivity);
        	break;
		case R.id.textViewListener1:
			Toast.makeText(this, "nie trafiles w przycisk ;p", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
