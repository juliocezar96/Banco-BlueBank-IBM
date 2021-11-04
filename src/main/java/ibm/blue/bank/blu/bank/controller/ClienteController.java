package ibm.blue.bank.blu.bank.controller;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.repository.ClienteRepository;
import ibm.blue.bank.blu.bank.repository.ContaRepository;
import ibm.blue.bank.blu.bank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping
    @ResponseBody //Retorna os dados para o corpo
    public ResponseEntity<List<Cliente>> listaClientes() {

//        Cliente cliente = new Cliente(null, "mateus", "9999999", "mateus@gmail.com", "99999999");
//        Conta conta = new Conta(null, 1, 1, 100, cliente);
//        contaRepository.save(conta);

        List<Cliente> clientes = clienteService.getCliente();
        return ResponseEntity.ok().body(clientes);
    }

}
