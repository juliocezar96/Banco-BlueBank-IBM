package ibm.blue.bank.blu.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository; 
	
	List<Cliente> clientes = clienteRepository.findAll();//Busca no banco 

	public List<Cliente> getCliente() {
		return clientes;
	}

}
