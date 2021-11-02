package ibm.blue.bank.blu.bank.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ibm.blue.bank.blu.bank.model.Transacao;


@Service
public class TransacaoService {
	public List<Transacao> getAll(){
	
		return Arrays.asList(new Transacao(1L,"11/2/21",100.00,1));
		
		}
}
