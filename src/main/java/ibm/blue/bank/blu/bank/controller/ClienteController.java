package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.service.ClienteService;


import java.util.List;

import ibm.blue.bank.blu.bank.service.ContaService;
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


}
