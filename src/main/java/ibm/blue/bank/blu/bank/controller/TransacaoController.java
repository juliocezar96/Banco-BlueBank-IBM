package ibm.blue.bank.blu.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import ibm.blue.bank.blu.bank.model.Transacao;
import ibm.blue.bank.blu.bank.service.TransacaoService;

@RestController
@RequestMapping (value = "/transacao")
public class TransacaoController {
	@Autowired
    TransacaoService transacaoService;
	
	@GetMapping(value = "/listatodos")
	@ResponseBody //Retorna os dados para o corpo
	public ResponseEntity<List<Transacao>> listaTransacoes(){
		return new ResponseEntity<List<Transacao>>(transacaoService.getTransacoes(), HttpStatus.OK);
	}
}
