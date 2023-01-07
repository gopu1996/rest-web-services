package com.rest.webservices.restwebservices.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.rest.webservices.restwebservices.exception.UserNotFoundException;
import com.rest.webservices.restwebservices.repository.PostsRepository;
import com.rest.webservices.restwebservices.repository.UserRepository;
import com.rest.webservices.restwebservices.user.PostEntity;
import com.rest.webservices.restwebservices.user.UserEntity;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostsRepository postsRepository;

	

	
	@GetMapping("/users")
	public List<UserEntity> retriveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}/posts")
	public List<PostEntity> retrivePostsForUser(@PathVariable int id){
		Optional<UserEntity> user =  userRepository.findById(id);
		if(user.isEmpty()) { throw new UserNotFoundException("id: "+ id);}
		
		return user.get().getPosts();
		
	}
	
	
	@PostMapping("/user/{id}/posts")
	public ResponseEntity<PostEntity> createPosts(@PathVariable int id ,@Valid @RequestBody PostEntity post) {
	   
		
		Optional<UserEntity> user =  userRepository.findById(id);
		if(user.isEmpty()) { throw new UserNotFoundException("id: "+ id);}
		
		post.setUserEntity(user.get());
		System.out.println(post);
		PostEntity savePost	= postsRepository.save(post);
	   
		URI url = ServletUriComponentsBuilder.fromCurrentRequest()
			   .path("/{id}").
			    buildAndExpand(savePost.getId()).toUri();
		
	   return ResponseEntity.created(url).build();
		
	}

	
	
	  	
	@GetMapping("/users/{id}")
	public EntityModel<UserEntity> retriveUsers(@PathVariable int id){
		Optional<UserEntity> user =  userRepository.findById(id);
		if(user.isEmpty()) { throw new UserNotFoundException("id: "+ id);}
		
		EntityModel<UserEntity> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
 	
	@PostMapping("/user")
	public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user) {
	   UserEntity saveUser	= userRepository.save(user);
	   URI url = ServletUriComponentsBuilder.fromCurrentRequest()
			   .path("/{id}").
			    buildAndExpand(saveUser.getiD()).toUri();
	   return ResponseEntity.created(url).build();
		
	}

	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id){
		userRepository.deleteById(id);
		}

}
