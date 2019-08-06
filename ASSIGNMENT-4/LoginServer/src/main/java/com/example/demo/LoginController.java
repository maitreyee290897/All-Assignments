package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@Controller
@RequestMapping("/rest/login")
public class LoginController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String getPage()
	{
		return "login";
	}
	@GetMapping("/callservice")
	public String invokeService(@RequestParam String x, @RequestParam String y)
	{
		String url="http://AUTH-SERVICE:8094/authenticate/"+x+"&"+y;
		return restTemplate.getForObject(url, String.class);
	}

}
