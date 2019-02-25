package com.example.androidticketingapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.*;

@SuppressLint("NewApi")
public class Login extends Activity implements View.OnClickListener{
	EditText username, pass;
	Button loginbtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		username = (EditText) findViewById(R.id.edit_Username);
		pass =(EditText) findViewById(R.id.edit_Password);
		loginbtn = (Button) findViewById(R.id.bt_Login);
		loginbtn.setOnClickListener(this);
		
		
		
	
		
	}
	
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.bt_Login:
			String userName, userPassword;
			userName = username.getText().toString();
			userPassword = pass.getText().toString();
			if(userName.isEmpty()&&userPassword.isEmpty())
			{
			Toast.makeText(getApplicationContext(), "Username is required\nPassword is required", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Log in success", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		
	}
	

}
