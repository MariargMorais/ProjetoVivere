package com.MariaRGMorais.Vivere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MariaRGMorais.Vivere.entity.Cashbook;

@Repository
public interface CashbookRepository extends JpaRepository<Cashbook, Integer> {

	List <Cashbook> findByClientId(int client);
	
	


}