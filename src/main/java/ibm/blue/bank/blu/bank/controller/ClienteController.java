package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.repository.ClienteRepository;
import ibm.blue.bank.blu.bank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Cliente> findAll(){

        Cliente cliente = new Cliente(1L,"Julio","81999999999","julio@teste.com","11122233301",
                new Conta(1L, 11, 1,1.000));

        return ResponseEntity.ok().body(cliente);
    }
}
