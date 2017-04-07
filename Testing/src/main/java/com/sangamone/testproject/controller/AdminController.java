package com.sangamone.testproject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AdminController {

	@RequestMapping(value={"/","login"}, method=RequestMethod.GET )
	public ModelAndView login (@RequestParam(value="error", required=false)String error,
	@RequestParam(value="logout", required=false)String logout){
		ModelAndView model=new ModelAndView();
		if(error!=null)
		{
			model.addObject("error","Invalid User Name and Password");
		}
		if(logout!=null)
		{
			model.addObject("sucess","You've Logout Sucessfully");
		}
		model.setViewName("login/login");
		
		
		return model;
		
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
	public ModelAndView home(){
		ModelAndView model=new ModelAndView();
		model.setViewName("home/home");
		return model;
	}

}
