package com.movieService.util;

public class QueryConstant {

	public static final String LOGINQUERY = "select username, password , status from users where username = ?";
	
	public static final String USERSTATUSACTIVE = "ACTIVE";
	
	public static final String USERSTATUSDEACTIVE = "DEACTIVE";
	
	public static final String USERSTATUSNOTEXIST = "NOTEXIST";
	
	public static final String UPDATE_TO_ACTIVATE = "UPDATE users SET status = 'A' WHERE username = ?";
	
	public static final String UPDATE_TO_DEACTIVATE = "UPDATE users SET status = 'D' WHERE username = ?";
	
	public static final String GETALLUSERS = "select username from users where status = 'A'";
	
		
}
