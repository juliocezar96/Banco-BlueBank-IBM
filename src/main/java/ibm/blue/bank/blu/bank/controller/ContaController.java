package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> listaContas() {

//        Cliente cliente = new Cliente(null, "mateus", "9999999", "mateus@gmail.com", "99999999");
//        Conta conta = new Conta(null, 1, 1, 100, cliente);
//        contaRepository.save(conta);
        return new ResponseEntity<List<Conta>>(contaService.getContas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Conta> cadastrar(@RequestBody Conta conta) {

        conta = this.contaService.cadastrar(conta);

        return ResponseEntity.ok().body(conta);

    }


}
