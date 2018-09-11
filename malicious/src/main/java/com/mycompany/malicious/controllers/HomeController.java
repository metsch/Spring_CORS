package com.mycompany.malicious.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController{

    @CrossOrigin
    @RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}