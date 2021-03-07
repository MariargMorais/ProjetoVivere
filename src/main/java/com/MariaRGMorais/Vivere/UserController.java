package com.MariaRGMorais.Vivere;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// create user
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		user.setDateTime(data.format(formatter));

		return this.userRepository.save(user);
	}

	// get user by id
	@GetMapping("/id/{userId}")
	public User getUserById(@PathVariable(value = "userId") int userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	}

	// get user by Email
	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable(value = "email") int userEmail) {
		return this.userRepository.findById(userEmail)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userEmail));
	}

	// update user 
	@PutMapping("/update/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable("userId") int userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		//existingUser.setDateTime(user.getDateTime());
		existingUser.setName(user.getName());
		existingUser.setLogin(user.getLogin());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setPhone(user.getPhone());
		existingUser.setStatus(user.getStatus());
		existingUser.setType(user.getType());
		return this.userRepository.save(existingUser);
	}

	// delete user by id
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}
}