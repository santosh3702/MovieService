package com.movieService.service;

import java.util.List;

import com.movieService.types.DeleteRequest;
import com.movieService.types.DeleteResponce;
import com.movieService.types.GetAllUsersResonce;
import com.movieService.types.LoginRequest;
import com.movieService.types.LoginResponce;

public interface LoginService {

	public LoginResponce login(LoginRequest crediantials);
	
	public DeleteResponce delete(DeleteRequest deleteRequest);
	
	public List<GetAllUsersResonce> getAllUsers();
}
