package org.abhi.controller;

import java.util.List;

import org.abhi.model.User;
import org.abhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userService;
	
	@PostMapping(path="save", consumes = {"application/json"})
	public HttpStatus addUser(@RequestBody User user) {
		userService.save(user);
		return HttpStatus.OK;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> addUser() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
}
