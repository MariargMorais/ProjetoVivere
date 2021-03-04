package com.MariaRGMorais.Vivere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MariaRGMorais.Vivere.entity.Client;
import com.MariaRGMorais.Vivere.entity.User;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{


}