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

		return this.cashbookRepository.save(cashbook);
		// return livroCaixaModel;

	}

	// get cashbooks by client id
	@GetMapping("/clientId/{clientId}")
	public Cashbook getCashbookByClientId(@PathVariable(value = "clientId") int clientId) {
		return this.cashbookRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found with client id :" + clientId));
	}

	// get cashbook by id
	@GetMapping("/id/{cashbookId}")
	public Cashbook getCashbookById(@PathVariable(value = "cashbookId") int cashbookId) {
		return this.cashbookRepository.findById(cashbookId).orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with client id :" + cashbookId));
	}

	// update cashbook
	@PutMapping("/update/{cashbookId}")
	public Cashbook updateCashbook(@RequestBody Cashbook cashbook) {

		return this.cashbookRepository.save(cashbook);
	}

	// delete cashbook by id
	@DeleteMapping("/delete/{cashbookId}")
	public void deleteCashbook(@PathVariable("cashbookId") Cashbook cashbookId) {
		cashbookRepository.delete(cashbookId);

	}
}