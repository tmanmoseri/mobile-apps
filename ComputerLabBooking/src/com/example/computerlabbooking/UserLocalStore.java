package com.example.computerlabbooking;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {
	
	public static final String SP_Name="userDetails";
	SharedPreferences userLocalDatadase;
	
	public UserLocalStore(Context context){
		userLocalDatadase=context.getSharedPreferences(SP_Name, 0);
	}
	
	public void storeuserData(User user){
		//@SuppressWarnings("unused")
		SharedPreferences.Editor spEditor=userLocalDatadase.edit();
		spEditor.putString("name", user.name);
		spEditor.putInt("age", user.age);
		spEditor.putString("username", user.username);
		spEditor.putString("password", user.password);
		spEditor.commit();
	}
	
	public User getLoggedInUser(){
		String name=userLocalDatadase.getString("name", "");
		int age=userLocalDatadase.getInt("age", -1);
		String username=userLocalDatadase.getString("username", "");
		String password=userLocalDatadase.getString("password", "");
		
		User storedUser=new User(name,age,username,password);
		
		return storedUser;
	}
	
	public void setUserLoggedIn(boolean loggedIn){
		SharedPreferences.Editor spEditor=userLocalDatadase.edit();
		spEditor.putBoolean("loggedIn", loggedIn);
		spEditor.commit();
	}
	
	public boolean getUserLogedIn(){
		if(userLocalDatadase.getBoolean("loggedIn", false)==true){
			return true;
		}else{
			return false;
		}
			
	}
	
	public void clearUserData(){
		SharedPreferences.Editor spEditor=userLocalDatadase.edit();
		spEditor.clear();
		spEditor.commit();
	}

}
