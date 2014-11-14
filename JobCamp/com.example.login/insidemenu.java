package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class insidemenu extends Activity {

	private static final int CAMERA_PIC_REQUEST = 1234;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insidemenu);
	}
	
	public void logexit(View exit) {
		
		//Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show();
		Button bo1;
		bo1 = (Button)findViewById(R.id.button1);
		bo1.setText("This is nay");
		
		Intent myintent = new Intent(this,logexit.class);
		finish();
		startActivity(myintent);
	}
	
	public void openkamera(View v) {
		
		Intent okamera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(okamera, CAMERA_PIC_REQUEST);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == CAMERA_PIC_REQUEST) {
			
			Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
			ImageView image2 = (ImageView) findViewById(R.id.imageView1);
			image2.setImageBitmap(thumbnail);
		}
	}
}
