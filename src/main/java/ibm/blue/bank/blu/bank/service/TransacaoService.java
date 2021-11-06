package ibm.blue.bank.blu.bank.service;


import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.model.Transacao;
import ibm.blue.bank.blu.bank.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class TransacaoService {
    @Autowired
    private ContaService contaService;
    @Autowired
    private TransacaoRepository transacaoRepository;


    public ResponseEntity<Transacao>  gerarTransacao(Double valor, Long idContaOrigem, Long idContaDestino) throws Exception {

        Optional<Conta> contaOrigem = contaService.getConta(idContaOrigem);
        Optional<Conta> contaDestino = contaService.getConta(idContaDestino);

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {
            if (transferirValor(valor, contaOrigem.get(), contaDestino.get())) {
                Date date = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
                formato.format(date);


                Transacao transacao = new Transacao(null, date, valor, contaDestino.get(), contaOrigem.get());
                return ResponseEntity.created(new URI("/transacao")).body(transacaoRepository.save(transacao));

            } else {
                return ResponseEntity.badRequest().build();
            }


        }
        return ResponseEntity.badRequest().build();

    }

    public Boolean transferirValor(Double valor, Conta contaOrigem, Conta contaDestino) throws Exception {
        if (valor <= contaOrigem.getSaldo()) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            contaService.cadastrar(contaDestino);
            contaService.cadastrar(contaOrigem);
            return true;


        } else {
            return false;

        }

    }

    public List<Transacao> getTransacoes() {
        List<Transacao> transacoes = transacaoRepository.findAll();//Busca no banco
        return transacoes;
    }


}
