package com.MariaRGMorais.Vivere;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.MariaRGMorais.Vivere.entity.Client;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	// create client
	@PostMapping("/create")
	public Client createClient(@RequestBody Client client) {

		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		client.setDateTime(data.format(formatter));

		return this.clientRepository.save(client);
	}

	// get all clients 
	@GetMapping("/allClients")
	public List <Client> getAllClients(){
		return this.clientRepository.findAll();
		
	}

	// get client by cpfcnpj
	@GetMapping("/cpfCnpj/{cpfcnpj}")
	public Client getClientByCpfcnpj(@PathVariable(value = "cpfcnpj") int clientCpfcnpj) {
		return this.clientRepository.findById(clientCpfcnpj)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + clientCpfcnpj));
	}

	// update client
	@PutMapping("/update/{clientId}")
	public Client updateClient(@RequestBody Client client, @PathVariable("clientIdid") int clientId) {
		Client existingClient = this.clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + clientId));
		//existingClient.setDateTime(client.getDateTime());
		existingClient.setName(client.getName());
		existingClient.setCpfcnpj(client.getCpfcnpj());
		existingClient.setAddress(client.getAddress());
		existingClient.setCity(client.getCity());
		existingClient.setState(client.getState());
		existingClient.setPostalCode(client.getPostalCode());
		existingClient.setPhone(client.getPhone());
		existingClient.setEmail(client.getEmail());
		return this.clientRepository.save(existingClient);
	}

	// delete client by id
	@DeleteMapping("/delete/{clientId}")
	public ResponseEntity<Client> deleteClient(@PathVariable("clientId") int clientId) {
		Client existingClient = this.clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + clientId));
		this.clientRepository.delete(existingClient);
		return ResponseEntity.ok().build();
	}
}