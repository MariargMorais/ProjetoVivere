package com.MariaRGMorais.Vivere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MariaRGMorais.Vivere.entity.User;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}

	// update user
	@PutMapping("/updateId/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") int userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		return this.userRepository.save(existingUser);
	}

	// get user by id
	@GetMapping("/getUser/{userId}")
	public User getUserById(@PathVariable(value = "userId") int userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	}

	// get user by Email
	@GetMapping("/getEmail/{email}")
	public User getUserByEmail(@PathVariable(value = "email") int userEmail) {
		return this.userRepository.findById(userEmail)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userEmail));
	}

	// delete user by id
	@DeleteMapping("/deleteId/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}
}