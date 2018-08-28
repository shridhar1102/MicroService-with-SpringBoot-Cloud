package com.restservice.usercontroller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.restserive.user.User;
import com.restservice.userdao.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping(path="/users")
	public List<User> retrievAll()
	{
		return userDao.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> retrievOne(@PathVariable int id)
	{
		
		User user= userDao.findById(id);
		if(user==null)
		{
			throw new UserNotFoundException("User Not Found");
		}
		
		Resource<User> resource= new Resource<User>(user);
		ControllerLinkBuilder lintTo=linkTo(methodOn(this.getClass()).retrievAll());
		resource.add(lintTo.withRel("All-Users"));

		return resource;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		 User savedUser=userDao.save(user);
		 URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteById(@PathVariable int id)
	{
		User deletedUser= userDao.deleteById(id);
		if(deletedUser==null)
		{
			throw new UserNotFoundException("User Not Found");
		}
		
	}

}
