package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.service.ClienteService;
import ibm.blue.bank.blu.bank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/conta")
public class ContaController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    ContaService contaService;

    @GetMapping(value = "/conta/listatodos")
    @ResponseBody
    public ResponseEntity<List<Conta>> listaContas(){
        return new ResponseEntity<List<Conta>>(contaService.getContas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Conta> cadastrar(@RequestBody Cliente cliente){

        Conta contaResult =  contaService.cadastrar(cliente);

        return ResponseEntity.ok().body(contaResult);

    }



}
