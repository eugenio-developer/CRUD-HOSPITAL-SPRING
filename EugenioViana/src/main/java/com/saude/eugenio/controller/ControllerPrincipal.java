package com.saude.eugenio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
  
@Controller
public class ControllerPrincipal {
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
}
