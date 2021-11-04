package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.model.Transacao;
import ibm.blue.bank.blu.bank.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;


    @PutMapping("/{valor}")
    public ResponseEntity<String> transferencia(@PathVariable Double valor, @RequestBody List<Conta> contas) {
        try {
            return ResponseEntity.ok().body(transacaoService.gerarTransacao(valor, contas.get(0), contas.get(1)));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/listatodos")
    public ResponseEntity<List<Transacao>> listaTransacoes() {
        return new ResponseEntity<List<Transacao>>(transacaoService.getTransacoes(), HttpStatus.OK);
    }
}
