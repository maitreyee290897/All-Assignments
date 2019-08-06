package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@Autowired
	private UserDAO obj;

	@RequestMapping("/path/{name}")
	public void add(@PathVariable String x)
	{
		System.out.println(x);
		User user=new User();
		user.setUser("Maitreyee");
		user.setPwd("Maitreyee");
		obj.save(user);

	}
}
