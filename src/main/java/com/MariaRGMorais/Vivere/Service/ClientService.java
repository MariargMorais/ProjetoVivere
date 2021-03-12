package com.MariaRGMorais.Vivere.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MariaRGMorais.Vivere.entity.Client;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional
	public Client insert(Client client) {
		Date dt = Date.from(Instant.now());
		client.setDateTime(dt);
		client = clientRepository.save(client);
		return client;
	}

	public  Client update(Client client) {
		clientRepository.findById(client.getId())
				.orElseThrow(() -> new ResourceNotFoundException("client not found with client id requested"));
		
		Date dt = Date.from(Instant.now());
		client.setDateTime(dt);
		client = clientRepository.save(client);
		return client;
	}

	public List<Client> getAllClients() {
		List<Client> obj = clientRepository.findAll();
		return obj;
	}

	public void delete(Client client) {
		clientRepository.delete(client);

	}

	public Client findByCpfcnpj(String clientCpfcnpj) {
		return this.clientRepository.findByCpfcnpj(clientCpfcnpj);

	}

}
