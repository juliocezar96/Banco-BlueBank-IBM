package ibm.blue.bank.blu.bank.service;


import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.model.Transacao;
import ibm.blue.bank.blu.bank.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class TransacaoService {
    @Autowired
    private ContaService contaService;
    @Autowired
    private TransacaoRepository transacaoRepository;


    public String gerarTransacao(Double valor, Conta contaOrigem, Conta contaDestino) throws Exception {

        if (transferirValor(valor, contaOrigem, contaDestino)) {
            Date date = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
            formato.format(date);


            Transacao transacao = new Transacao(null, date, valor, contaDestino, contaOrigem);
            transacaoRepository.save(transacao);
            return "transferencia realizada com sucesso";

        } else {
            return "Saldo insuficiente para realizar transferencia";
        }


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
