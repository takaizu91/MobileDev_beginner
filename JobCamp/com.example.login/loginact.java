package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginact extends Activity {
	
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		setContentView(R.layout.loginact);
	}
	
	public void insidemenu(View enter) {
		
		//Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show();
		
		EditText t1, t2;
		//Button b1;
		String s1, s2;
		t1 = (EditText)findViewById(R.id.editText1);
		t2 = (EditText)findViewById(R.id.editText2);
		//b1 = (Button)findViewById(R.id.button1);
		s1 = t1.getText().toString();
		s2 = t2.getText().toString();
		t1.setText("Travis");
		t2.setText("rofl");
		//b1.setText("processing...");
		
		if (s1.length()== 0 || s2.length() == 0) {
			Toast.makeText(this, "imcomplete data", Toast.LENGTH_LONG).show();
		}
		
		else {
		
		Intent myintent = new Intent(this,insidemenu.class);
		finish();
		startActivity(myintent);
		}
	}

}

