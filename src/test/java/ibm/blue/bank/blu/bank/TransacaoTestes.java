package ibm.blue.bank.blu.bank;

import ibm.blue.bank.blu.bank.controller.TransacaoController;
import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.model.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransacaoTestes {
    static TransacaoController transacaoController;
    static Conta cOrigem;
    static Conta cDestino;
    Double valor;

    @BeforeEach
    @Test
    void setUp(){
        Cliente cliente = new Cliente();
        cDestino = new Conta(1L,1L,1L,100.0, cliente);
        cOrigem = new Conta(2L,2L,1L,100.0, cliente);
        valor = 100.00;
    }

    @Test
    void deveListarTransacoesTest (){
        Long id = 3L;
        Date data = new Date();


        Transacao t = new Transacao(id, data,valor, cDestino, cOrigem);

        List<Transacao>listaTransacoes = new ArrayList();
        listaTransacoes.add(t);

        ResponseEntity<List<Transacao>> transacoes = transacaoController.listaTransacoes();

        Assertions.assertEquals(listaTransacoes, transacoes.getBody());
    }

    @Test
    void deveTerSaldoSuficienteTeste(){
        Assertions.assertEquals(cOrigem.getSaldo() < valor, false);
    }
}
