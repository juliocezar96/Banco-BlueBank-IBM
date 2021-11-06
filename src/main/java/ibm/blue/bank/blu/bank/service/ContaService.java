package ibm.blue.bank.blu.bank.service;


import ibm.blue.bank.blu.bank.model.Conta;
import ibm.blue.bank.blu.bank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getContas() {
        List<Conta> contas = contaRepository.findAll();
        return contas;
    }

    public Optional<Conta> getConta(Long id) {
        Optional<Conta> contas = contaRepository.findById(id);
        return contas;
    }

    public Conta cadastrar(Conta conta) {

        return contaRepository.save(conta);
    }

}
