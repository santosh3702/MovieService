package com.movieService.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieService.types.LoginCrediantials;

@RestController
@CrossOrigin()
@RequestMapping(value = "/movieService")
public class MovieController {

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE ,consumes =  MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
	public LoginCrediantials test(@RequestBody LoginCrediantials value) {
		LoginCrediantials crediantials = new LoginCrediantials();
		crediantials.setUserName(value.getUserName());
		crediantials.setPassword(value.getPassword());
		return crediantials;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public boolean login(@RequestBody LoginCrediantials countryName)  {
		
		return true;
	}

}
