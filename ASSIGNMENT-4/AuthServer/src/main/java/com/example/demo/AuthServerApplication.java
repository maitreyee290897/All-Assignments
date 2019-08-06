package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	
	}
	@Autowired
	private UserDAO userDao;


	
	@RequestMapping("/authenticate/{name}&{pwd}")
	public String verify(@PathVariable(value="name") String name,@PathVariable(value="pwd") String pwd) 
	{  	System.out.println(name);
       System.out.println(pwd);
		
		User u=new User();
		//this is data in database
		u.setUser("Sang");
		u.setPwd("sang");
		userDao.save(u);
		
		User user=userDao.findUser(name,pwd);
		   if(user==null)
		   {
			return "failure";
		   }
		   else 
		   {
		     return "success";
			  
		   }
	  
	}
	


}
