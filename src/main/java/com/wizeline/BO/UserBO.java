package com.wizeline.BO;

public interface UserBO {

	String createUser(String user, String password);
	
	String login(String user, String password);
	
}
