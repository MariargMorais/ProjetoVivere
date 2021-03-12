package com.MariaRGMorais.Vivere;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MariaRGMorais.Vivere.Service.UserService;
import com.MariaRGMorais.Vivere.entity.User;
import com.MariaRGMorais.Vivere.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	// create user
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User us = userService.insert(user);
		return ResponseEntity.ok().body(us);
	}

	// login user
	@GetMapping("/login")
	public String loginUser(@RequestBody User user) {
		User login = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
		if (login != null) {
			if (login.getStatus().equals("A")) {
				return "Logged in";
			} else {
				return "Inactive user";
			}
		} else {
			return "Username or password is invalid";
		}
	}

	// get user by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) {
		User us = userService.byId(userId);
		return ResponseEntity.ok().body(us);
	}

	// get user by Email n name
	@GetMapping("/search")
	public ResponseEntity<List<User>> getUserByEmail(@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "name", defaultValue = "") String name) {
		List<User> us = userService.bySearch(email, name);
		return ResponseEntity.ok().body(us);
	}

	// update user
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id, @RequestBody User user) {
		user.setId(id);
		User us = userService.update(user);
		return ResponseEntity.ok().body(us);
	}

	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") User userId) {
		userService.delete(userId);
		return ResponseEntity.noContent().build();

	}
}