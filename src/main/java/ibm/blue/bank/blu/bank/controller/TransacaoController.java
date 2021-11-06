package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.model.Transacao;
import ibm.blue.bank.blu.bank.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;


    @PostMapping
    public ResponseEntity<Transacao> transferencia(@RequestParam("valor") Double valor, @RequestParam("origem") Long idContaOrigem, @RequestParam("destino") Long idContaDestino) throws Exception {

        return transacaoService.gerarTransacao(valor, idContaOrigem, idContaDestino);

    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listaTransacoes() {
        return new ResponseEntity<List<Transacao>>(transacaoService.getTransacoes(), HttpStatus.OK);
    }
}
