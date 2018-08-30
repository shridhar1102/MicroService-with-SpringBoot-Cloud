package com.restservice.usercontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.restservice.user.User;
import com.restservice.userdao.PostRepository;
import com.restservice.userdao.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRespository;
	@Autowired
	private PostRepository postRepository;
	
	
	@GetMapping(path="/users")
	public List<User> retrievAll()
	{
		return userRespository.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> retrievOne(@PathVariable int id)
	{
		
		Optional<User> user= userRespository.findById(id);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User Not Found");
		}
		
		Resource<User> resource= new Resource<User>(user.get());
		ControllerLinkBuilder lintTo=linkTo(methodOn(this.getClass()).retrievAll());
		resource.add(lintTo.withRel("All-Users"));

		return resource;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		 User savedUser=userRespository.save(user);
		 URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteById(@PathVariable int id)
	{
		 userRespository.deleteById(id);
		
		
	}
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> retrieveAll(@PathVariable int id)
	{
		
		Optional<User> user= userRespository.findById(id);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User Not Found");
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping(path="/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post)
	{
		Optional<User> userOptional= userRespository.findById(id);
		if(!userOptional.isPresent())
		{
			throw new UserNotFoundException("User Not Found");
		}
		User user=userOptional.get();
        post.setUser(user);	
        postRepository.save(post);

		 URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		 return ResponseEntity.created(location).build();
	}

}
