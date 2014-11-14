package com.corruptor.smssender;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//import android.content.Intent;

public class smsMenu extends Activity{
	
	EditText textPhoneNo;
	EditText textSMS;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smslayout);
		textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
		textSMS = (EditText) findViewById(R.id.editTextSMS);
	}
	
	public void sendsms(View v)
	{
		String phoneNo = textPhoneNo.getText().toString();
		String sms = textSMS.getText().toString();
		try 
		{
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo, null, sms, null, null);
			Toast.makeText(getApplicationContext(), "SMS Sent!",
			Toast.LENGTH_LONG).show();
		}
		catch(Exception e) 
		{
			Toast.makeText(getApplicationContext(),
			"SMS failed, please try again later!",
			Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}
}
