package ibm.blue.bank.blu.bank.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.blue.bank.blu.bank.model.Transacao;
import ibm.blue.bank.blu.bank.repository.TransacaoRepository;


@Service
public class TransacaoService {
	@Autowired
	TransacaoRepository transacaoRepository; 
	
	List<Transacao> transacoes = transacaoRepository.findAll();//Busca no banco 

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	
	
	
	
	
}
