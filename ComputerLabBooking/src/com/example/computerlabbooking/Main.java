package com.example.computerlabbooking;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;


public class Main extends ActionBarActivity implements View.OnClickListener{
	
	Button bLogout;
	EditText etName, etAge, etUsername;
	UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etName=(EditText) findViewById(R.id.etName);
		etAge=(EditText) findViewById(R.id.etAge);
		etUsername=(EditText) findViewById(R.id.etUsername);
		bLogout=(Button) findViewById(R.id.bLogout);
		
		bLogout.setOnClickListener(this);
		
		userLocalStore=new UserLocalStore(this);
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	if(authenticate()==true){
    		displayUserDetails();
    	}else{
    		startActivity(new Intent(Main.this,Login.class));
    	}
    }
    
    private boolean authenticate(){
    	return userLocalStore.getUserLogedIn();
    }
    
    private void displayUserDetails(){
    	User user=userLocalStore.getLoggedInUser();
    	etUsername.setText(user.username);
    	etName.setText(user.name);
    	etAge.setText(user.age+"");   
    }
    

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bLogout:
			userLocalStore.clearUserData();
			userLocalStore.setUserLoggedIn(false);
			
			startActivity(new Intent(this,Login.class));
			break;}}  
}
