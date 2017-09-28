package com.imagestore.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	Logger logger = Logger.getLogger(WelcomeController.class);
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String welcome(Map<String, Object> model) {
		logger.info("coming inside welcome:: ");
		model.put("message", this.message);
		return "welcome";
	}

}