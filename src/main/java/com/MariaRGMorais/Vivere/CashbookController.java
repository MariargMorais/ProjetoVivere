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
import org.springframework.web.bind.annotation.RestController;

import com.MariaRGMorais.Vivere.Service.CashbookService;
import com.MariaRGMorais.Vivere.entity.Cashbook;
import com.MariaRGMorais.Vivere.entity.DTO.CashbookInsert;

@RestController
@RequestMapping("/cashbooks")
public class CashbookController {

	@Autowired
	private CashbookService cashbookService;

	// create cashbook
	@PostMapping("/create")
	public ResponseEntity<Cashbook> createCashbook(@RequestBody CashbookInsert cashbookInsert) {

		Cashbook cashbook = cashbookService.insert(cashbookInsert);

		return ResponseEntity.ok().body(cashbook);

	}

	// get cashbooks by client id
	@GetMapping("/clientId/{id}")
	public ResponseEntity < List <Cashbook>>  getCashbookByClientId(@PathVariable(value = "id") int client) {
		List <Cashbook> cashS = cashbookService.ByclientId(client);

		return ResponseEntity.ok().body(cashS);

	}

	// get cashbook by id
	@GetMapping("/{id}")
	public ResponseEntity<Cashbook> getCashbookById(@PathVariable(value = "id") int cashbook) {
		Cashbook cashS = cashbookService.cashbookById(cashbook);
		return ResponseEntity.ok().body(cashS);
	}

	// update cashbook
	@PutMapping("/{id}")
	public ResponseEntity<Cashbook> updateCashbook(@RequestBody CashbookInsert cashbook) {
		Cashbook cashS = cashbookService.update(cashbook);
		return ResponseEntity.ok().body(cashS);
	}

	// delete cashbook by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Cashbook> deleteCashbook(@PathVariable("id") Cashbook cashbook) {
		cashbookService.delete(cashbook);
		return ResponseEntity.noContent().build();

	}
}