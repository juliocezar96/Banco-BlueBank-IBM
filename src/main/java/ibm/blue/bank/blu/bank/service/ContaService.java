package ibm.blue.bank.blu.bank.service;


import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> getContas() {
        List<Conta> contas = contaRepository.findAll();
        return contas;
    }

    public Conta cadastrar(Cliente cliente){

        Conta conta = new Conta(null,123,2,100.00, cliente);

        return contaRepository.save(conta);
    }

}
