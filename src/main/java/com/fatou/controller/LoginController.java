package com.fatou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService flour;
	
	
//	@RequestMapping(value = "/login")
//	@ResponseBody
//	public String ingredients() {
//		return  "egg flour";
//	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String ingredients() {
		return  "login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String Ahalfwarmmilk(@RequestParam String name,@RequestParam String password,ModelMap model) {
		if(!flour.validateUser(name, password)) {
			model.put("errorMessage","Invalid Credentials");
			return "login";
			
		}
		
		model.put("name", name);
		model.put("password", password);
		return  "welcome";
	}

	
}
