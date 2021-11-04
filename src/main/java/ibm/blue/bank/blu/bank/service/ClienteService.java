package ibm.blue.bank.blu.bank.service;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> getCliente() {
        List<Cliente> clientes = clienteRepository.findAll();//Busca no banco
        return clientes;
    }


}
