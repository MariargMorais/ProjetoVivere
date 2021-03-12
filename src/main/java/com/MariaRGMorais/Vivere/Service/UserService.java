package com.MariaRGMorais.Vivere.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MariaRGMorais.Vivere.entity.User;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User insert(User user) {
		Date dt = Date.from(Instant.now());
		user.setDateTime(dt);
		user = userRepository.save(user);
		return user;
	}

	public User update(User user) {
		userRepository.findById(user.getId())
		.orElseThrow(() -> new ResourceNotFoundException("user not found with client id requested"));

		Date dt = Date.from(Instant.now());
		user.setDateTime(dt);
		user = userRepository.save(user);
		return user;
	}

	public void delete(User user) {
		userRepository.delete(user);

	}
	
	public User byId(int client) {

		return this.userRepository.findById(client)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with client id :" + client));
	}
	
	public List <User> bySearch(String email, String name) {
		return this.userRepository.findByEmailContainingAndNameContaining(email, name);
	}

	public String login(User user) {
		User login = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
		String status;
		if (login != null) {
			if (login.getStatus().equals("A")) {
				status = "Logged in";
			} else {
				status = "Inactive user";
			}
		} else {
			status = "Username or password is invalid";
		}
		return status;
	}

}
