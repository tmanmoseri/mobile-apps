package com.example.androidticketingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartScreen extends Activity {
	private boolean backbtnpress;
	private static final int SPALSH_DURATION = 3000;
	private Handler myHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		myHandler = new Handler();
		myHandler.postDelayed(new Runnable(){
			public void run()
			{
				finish();
				if(!backbtnpress)
				{
					Intent intent= new Intent(StartScreen.this,MainActivity.class);
					StartScreen.this.startActivity(intent);
				}
			}
		},SPALSH_DURATION
				);
		
	}
	public void onBackPressed()
	{
		backbtnpress=true;
		super.onBackPressed();
	}

}
