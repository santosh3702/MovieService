package com.movieService.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.movieService.types.LoginCrediantials;

@RestController
public class MovieController {

	@RequestMapping(value = "/movie")
	public ModelAndView moviePageView() {
		return new ModelAndView("movie");
	}
	

	
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView saveUserDetails(@ModelAttribute("loginCrediantials") LoginCrediantials loginCrediantials){  
        System.out.println(loginCrediantials.getUserName());
        return new ModelAndView("success");
    }  

}
