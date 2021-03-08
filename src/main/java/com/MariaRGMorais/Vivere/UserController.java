package com.MariaRGMorais.Vivere;

import org.springframework.beans.factory.annotation.Autowired;
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

		return this.userRepository.save(user);
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
	@GetMapping("/id/{userId}")
	public User getUserById(@PathVariable(value = "userId") int userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	}

	// get user by Email
	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable(value = "email") String userEmail) {
		return this.userRepository.findByEmail(userEmail);
	}

	// update user
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		
		return this.userRepository.save(user);
	}

	// delete user by id
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable("userId") User userId) {

		userRepository.delete(userId);

	}
}