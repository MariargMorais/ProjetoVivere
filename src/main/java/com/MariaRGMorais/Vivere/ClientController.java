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

import com.MariaRGMorais.Vivere.Service.ClientService;
import com.MariaRGMorais.Vivere.entity.Client;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	// create client
	@PostMapping("/create")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		Client cli = clientService.insert(client);
		return ResponseEntity.ok().body(cli);
	}

	// get all clients
	@GetMapping
	public ResponseEntity<List<Client>> getAllClients() {
		List<Client> cli = clientService.getAllClients();
		return ResponseEntity.ok().body(cli);
	}

	// get client by cpfcnpj
	@GetMapping("/cpfCnpj/{cpfcnpj}")
	public ResponseEntity<Client> getClientByCpfcnpj(@PathVariable(value = "cpfcnpj") String clientCpfcnpj) {
		Client cli = clientService.findByCpfcnpj(clientCpfcnpj);
		return ResponseEntity.ok().body(cli);
	}

	// update client
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") int id,@RequestBody Client client) {
		client.setId(id);
		Client cli = clientService.update(client);
		return ResponseEntity.ok().body(cli);

	}

	// delete client by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable("id") Client clientId) {
		clientService.delete(clientId);
		return ResponseEntity.noContent().build();

	}
}