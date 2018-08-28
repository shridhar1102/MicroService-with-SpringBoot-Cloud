package com.restservice.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Filtering {
	
	@GetMapping("/filtering")
	public SomeBean retriveSomeBean()
	{
		SomeBean someBean = new SomeBean("value1","value2","value3");
		return someBean;
	}
	
	
	

}
