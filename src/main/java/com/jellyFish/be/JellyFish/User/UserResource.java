package com.jellyFish.be.JellyFish.User;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Validated
public class UserResource {
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return service.findAll();
	}

	@PostMapping("/createUser")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

//		if(ValidateResponseData(user)) {
//			
//		}
//		if (user.getName() == null) {
//			throw new UsernameNullException("Username is EMPTY");
//		} else {
		service.addUser(user);
//		}

		return ResponseEntity.created(null).build();
	}

//	private Boolean ValidateResponseData(User user) {
//		// TODO Auto-generated method stub
//		else if (user.getPassword() == null) {
//			throw new PasswordNullException("Password is EMPTY");
//		}
//
//	}

	@GetMapping("/users/{name}")
	public User retrieveUser(@PathVariable String name) {
		User user = service.findOne(name);

		if (user == null) {
			throw new UserNotFoundException("name:" + name);
		}

		return user;
	}

}
