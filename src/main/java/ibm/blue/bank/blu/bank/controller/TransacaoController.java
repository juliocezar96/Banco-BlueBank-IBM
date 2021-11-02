package ibm.blue.bank.blu.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ibm.blue.bank.blu.bank.model.Transacao;
import ibm.blue.bank.blu.bank.service.TransacaoService;

@RestController
@RequestMapping (value = "/transacao")
public class TransacaoController {
	@Autowired
    TransacaoService transacaoService;
	
	@GetMapping
	public List<Transacao> getTransacao(){
		return transacaoService.getAll();
	}
	
}
