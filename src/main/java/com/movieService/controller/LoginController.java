package com.movieService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieService.service.LoginService;
import com.movieService.types.DeleteRequest;
import com.movieService.types.DeleteResponce;
import com.movieService.types.GetAllUsersResonce;
import com.movieService.types.LoginRequest;
import com.movieService.types.LoginResponce;

@RestController
@CrossOrigin()
@RequestMapping(value = "/loginService")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE ,consumes =  MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
	public LoginResponce login(@RequestBody LoginRequest crediantials) {
		LoginResponce loginResponce = null;
		loginResponce = loginService.login(crediantials);
		return loginResponce;
	}
	
	@RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE ,consumes =  MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
	public DeleteResponce delete(@RequestBody DeleteRequest deleteRequest) {
		DeleteResponce deleteResponce = null;
		deleteResponce = loginService.delete(deleteRequest);
		return deleteResponce;
	}
	
	@RequestMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE ,consumes =  MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
	public List<GetAllUsersResonce> getAllUsers() {
		List<GetAllUsersResonce> getAllUsersResonce = null;
		getAllUsersResonce = loginService.getAllUsers();
		return getAllUsersResonce;
	}
	
	
	
	
	
	
	

}
