package com.example.androidticketingapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

	Button Login , Create;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		Login = (Button) findViewById(R.id.btLogin);
		Create = (Button) findViewById(R.id.btCreate);
		Login.setOnClickListener(this);
		Create.setOnClickListener(this);
	}
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.btLogin:
			startActivity(new Intent(this,Login.class));
			break;
		case R.id.btCreate:
			startActivity(new Intent(this,CreateAccount.class));
			break;
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
