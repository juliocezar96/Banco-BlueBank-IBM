package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/cliente")
public class ClienteController {

  //  @GetMapping
//    public ResponseEntity<Cliente> findAll(){

        //Cliente cliente = new Cliente(1L,"Julio","81999999999","julio@teste.com","11122233301",
          //      new Conta(1L, 11, 1) );

        //return ResponseEntity.ok().body(cliente);
//    }
}
