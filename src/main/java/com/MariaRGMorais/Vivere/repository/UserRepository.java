package com.MariaRGMorais.Vivere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MariaRGMorais.Vivere.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByLoginAndPassword(String login, String password);
	User findByEmail(String email);
}