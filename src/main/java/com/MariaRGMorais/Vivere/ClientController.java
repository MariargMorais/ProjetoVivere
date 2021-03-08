package com.MariaRGMorais.Vivere;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MariaRGMorais.Vivere.entity.Client;
import com.MariaRGMorais.Vivere.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	// create client
	@PostMapping("/create")
	public Client createClient(@RequestBody Client client) {

//		LocalDateTime data = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		client.setDateTime(data.format(formatter));

		return this.clientRepository.save(client);
	}

	// get all clients 
	@GetMapping("/allClients")
	public List <Client> getAllClients(){
		return this.clientRepository.findAll();
		
	}

	// get client by cpfcnpj
	@GetMapping("/cpfCnpj/{cpfcnpj}")
	public Client getClientByCpfcnpj(@PathVariable(value = "cpfcnpj") String clientCpfcnpj) {
		return this.clientRepository.findByCpfcnpj(clientCpfcnpj);
	}

	// update client
	@PutMapping("/update/{clientId}")
	public Client updateClient(@RequestBody Client client) {
		
		return this.clientRepository.save(client);
	}

	// delete client by id
	@DeleteMapping("/delete/{clientId}")
	public void deleteClient(@PathVariable("clientId") Client clientId) {
		clientRepository.delete(clientId);
		
	}
}