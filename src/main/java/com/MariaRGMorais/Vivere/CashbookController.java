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
import com.MariaRGMorais.Vivere.entity.Cashbook.Type;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.CashbookRepository;

@RestController
@RequestMapping("/api/cashbooks")
public class CashbookController {

	@Autowired
	private CashbookRepository cashbookRepository;

	// create cashbook
	@PostMapping
	public Cashbook createCashbook(@RequestBody Cashbook cashbook) {

		if (cashbook.getType() == Type.DEBIT || cashbook.getType() == Type.CREDIT) {
			LocalDateTime data = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			cashbook.setDateTime(data.format(formatter));

			return this.cashbookRepository.save(cashbook);
			// return livroCaixaModel;
		} else {
			return cashbook;
		}

	}

	// get cashbooks by client id
	@GetMapping("/{clientid}")
	public Cashbook getCashbookByClientId(@PathVariable(value = "ClientId") int ClientId) {
		return this.cashbookRepository.findById(ClientId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with id :" + ClientId));
	}

	// get cashbook by id
	@GetMapping("/{cashbookid}")
	public Cashbook getCashbookById(@PathVariable(value = "id") int cashbookId) {
		return this.cashbookRepository.findById(cashbookId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with id :" + cashbookId));
	}

	// update cashbook
	@PutMapping("/{id}")
	public Cashbook updateCashbook(@RequestBody Cashbook cashbook, @PathVariable("id") int cashbookId) {
		Cashbook existingCashbook = this.cashbookRepository.findById(cashbookId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with id :" + cashbookId));
		existingCashbook.setCashbookId(cashbook.getCashbookId());
		existingCashbook.setClientId(cashbook.getClientId());
		existingCashbook.setDateTime(cashbook.getDateTime());
		existingCashbook.setDescription(cashbook.getDescription());
		existingCashbook.setType(cashbook.getType());
		existingCashbook.setValue(cashbook.getValue());
		return this.cashbookRepository.save(existingCashbook);
	}

	// delete cashbook by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Cashbook> deleteCashbook(@PathVariable("id") int cashbookId) {
		Cashbook existingCashbook = this.cashbookRepository.findById(cashbookId)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with id :" + cashbookId));
		this.cashbookRepository.delete(existingCashbook);
		return ResponseEntity.ok().build();
	}
}