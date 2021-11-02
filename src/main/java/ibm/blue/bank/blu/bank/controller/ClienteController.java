package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.service.ClienteService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/listatodos")
    @ResponseBody //Retorna os dados para o corpo
    public ResponseEntity<List<Cliente>> listaClientes(){
    		return new ResponseEntity<List<Cliente>>(clienteService.getCliente(), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<Cliente> findAll(){

        Cliente cliente = new Cliente(1L,"Julio","81999999999","julio@teste.com","11122233301",
                new Conta(1L, 11, 1,1.000));

        return ResponseEntity.ok().body(cliente);
    }
    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
        cliente = clienteService.cadastrar(cliente);
        return ResponseEntity.ok().body(cliente);

    }

    @DeleteMapping
    public ResponseEntity<Cliente> deletar(Cliente cliente){
        clienteService.deletar(cliente);
        return

    }

}
