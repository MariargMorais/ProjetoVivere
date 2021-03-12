package com.MariaRGMorais.Vivere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MariaRGMorais.Vivere.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByLoginAndPassword(String login, String password);
	List<User> findByEmailContainingAndNameContaining(String email, String name );
}