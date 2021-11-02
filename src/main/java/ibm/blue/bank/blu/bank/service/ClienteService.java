package ibm.blue.bank.blu.bank.service;

import java.util.List;
import java.util.Optional;

import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;


	public List<Cliente> getCliente() {
		List<Cliente> clientes = clienteRepository.findAll();//Busca no banco
		return clientes;
	}



}
