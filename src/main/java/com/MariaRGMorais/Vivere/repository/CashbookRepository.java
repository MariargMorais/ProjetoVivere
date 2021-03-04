package com.MariaRGMorais.Vivere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MariaRGMorais.Vivere.entity.Cashbook;
import com.MariaRGMorais.Vivere.entity.User;

@Repository
public interface CashbookRepository extends JpaRepository<Cashbook, Integer>{

}