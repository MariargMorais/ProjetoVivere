package com.MariaRGMorais.Vivere.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MariaRGMorais.Vivere.entity.Cashbook;
import com.MariaRGMorais.Vivere.entity.Client;
import com.MariaRGMorais.Vivere.entity.DTO.CashbookInsert;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.CashbookRepository;
import com.MariaRGMorais.Vivere.repository.ClientRepository;

@Service
public class CashbookService {

	@Autowired
	private CashbookRepository cashbookRepository;
	@Autowired
	private ClientRepository clientRepository;

	@Transactional
	public Cashbook insert(CashbookInsert cash) {

		Client client = clientRepository.findById(cash.getClient())
				.orElseThrow(() -> new ResourceNotFoundException("Client not found"));
		Cashbook cashbook = new Cashbook(cash.getDateTime(), cash.getDescription(), cash.getType(), cash.getValue(),
				client);
		cashbook = cashbookRepository.save(cashbook);
		return cashbook;
	}

	public Cashbook update(CashbookInsert cashbook) {
		cashbookRepository.findById(cashbook.getId())
				.orElseThrow(() -> new ResourceNotFoundException("user not found with client id requested"));
		Client client = clientRepository.findById(cashbook.getClient())
				.orElseThrow(() -> new ResourceNotFoundException("Client not found"));
		Cashbook cash = new Cashbook(cashbook.getDateTime(), cashbook.getDescription(), cashbook.getType(),
				cashbook.getValue(), client);
		Date dt = Date.from(Instant.now());
		client.setDateTime(dt);
		cash = cashbookRepository.save(cash);
		return cash;
	}

	public void delete(Cashbook cashbook) {
		cashbookRepository.delete(cashbook);

	}

	public List<Cashbook> ByclientId(int client) {

		return this.cashbookRepository.findByClientId(client);
	}

	public Cashbook cashbookById(int cashbook) {
		return this.cashbookRepository.findById(cashbook)
				.orElseThrow(() -> new ResourceNotFoundException("Cashbook not found with client id :" + cashbook));

	}

}
