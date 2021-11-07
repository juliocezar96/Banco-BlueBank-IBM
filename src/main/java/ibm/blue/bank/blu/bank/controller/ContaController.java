package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> listaContas() {
        return new ResponseEntity<List<Conta>>(contaService.getContas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Conta> cadastrar(@RequestBody Conta conta) throws URISyntaxException {

        if ((conta.getSaldo() == null) ||(conta.getDigito() == null) || (conta.getNumero() == null) || (conta.getCliente() == null)) {
            return ResponseEntity.badRequest().body(conta);
        }else if((conta.getCliente().getCpf() ==null) || (conta.getCliente().getNome() == null ) || (conta.getCliente().getTelefone() == null) || (conta.getCliente().getEndereco() == null) ){
            return ResponseEntity.badRequest().body(conta);
        }else {
            conta = contaService.cadastrar(conta);

            return ResponseEntity.created(new URI("/conta")).body(conta);
        }
    }
}
