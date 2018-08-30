package com.restservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping(value="/person/param", params="version=1")
	public Person1 person1()
	{
		return new Person1("Shridhar Kevati");
	}
	@GetMapping(value="/person/param", params="version=2")
	public Person2 person2()
	{
		return new Person2(new Name("Shridhar","Kevati"));
	}
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public Person1 header1()
	{
		return new Person1("Shridhar Kevati");
	}
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public Person2 header2()
	{
		return new Person2(new Name("Shridhar","Kevati"));
	}
//	@GetMapping(value="/person/produces", produces="/application/vnd.company.app-v1+json")
//	public Person1 producesV1()
//	{
//		return new Person1("Shridhar Kevati");
//	}
//	
//	@GetMapping(value="/person/produces", produces="/application/vnd.company.app-v2+json")
//	public Person2 producesV2()
//	{
//		return new Person2(new Name("Shridhar","Kevati"));
//	}
}
