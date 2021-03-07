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

import com.MariaRGMorais.Vivere.entity.Cashbook;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.CashbookRepository;

@RestController
@RequestMapping("/cashbooks")
public class CashbookController {

	@Autowired
	private CashbookRepository cashbookRepository;

	// create cashbook
	@PostMapping("/create")
	public Cashbook createCashbook(@RequestBody Cashbook cashbook) {

		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		cashbook.setDateTime(data.format(formatter));

		return this.cashbookRepository.save(cashbook);
		// return livroCaixaModel;

	}

	// get cashbooks by client id
	@GetMapping("/id/{clientid}")
	public Cashbook getCashbookByClientId(@PathVariable(value = "ClientId") int ClientId) {
		return this.cashbookRepository.findById(ClientId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with client id :" + ClientId));
	}

	// get cashbook by id
	@GetMapping("/id/{cashbookid}")
	public Cashbook getCashbookById(@PathVariable(value = "cashbookId") int cashbookId) {
		return this.cashbookRepository.findById(cashbookId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with id :" + cashbookId));
	}

	// update cashbook
	@PutMapping("/update/{cashbookId}")
	public Cashbook updateCashbook(@RequestBody Cashbook cashbook, @PathVariable("cashbookId") int cashbookId) {
		Cashbook existingCashbook = this.cashbookRepository.findById(cashbookId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with id :" + cashbookId));
		existingCashbook.setCashbookId(cashbook.getCashbookId());
		//existingCashbook.setDateTime(cashbook.getDateTime());
		existingCashbook.setDescription(cashbook.getDescription());
		existingCashbook.setType(cashbook.getType());
		existingCashbook.setValue(cashbook.getValue());
		return this.cashbookRepository.save(existingCashbook);
	}

	// delete cashbook by id
	@DeleteMapping("/delete/{cashbookId}")
	public ResponseEntity<Cashbook> deleteCashbook(@PathVariable("cashbookId") int cashbookId) {
		Cashbook existingCashbook = this.cashbookRepository.findById(cashbookId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with id :" + cashbookId));
		this.cashbookRepository.delete(existingCashbook);
		return ResponseEntity.ok().build();
	}
}