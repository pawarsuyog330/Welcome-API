package com.ashokit.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.ashokit.client.GreetFeignClient;

@RestController
public class WelcomeRestController {

	private Logger logger=LoggerFactory.getLogger(WelcomeRestController.class);
	
	@Autowired
	private GreetFeignClient client;
	
	@GetMapping("/welcome")
	public String welcomeMsg()
	{
		logger.info("Welcome msg execution started");
		String welcomeMsg= "Welcome to Ashok IT";
		
//		RestTemplate rt=new RestTemplate();
//		rt.getForEntity("http://localhost:9090/greet", String.class);
		
		String greetMsg = client.invokeGreetApi();
		logger.info("Welcome msg execution ended");
		
		return greetMsg + ", " + welcomeMsg;
		
	}
}
