package org.elevenfifty.managementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/Welcome")
	public String welcome(Model model) {
		return "welcome";
	}
		
	
	
}
