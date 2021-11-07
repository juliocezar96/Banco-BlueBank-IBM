package ibm.blue.bank.blu.bank;


import ibm.blue.bank.blu.bank.controller.ClienteController;
import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.repository.ClienteRepository;
import ibm.blue.bank.blu.bank.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.*;

public class ClienteTestes {
    @Autowired
    ClienteService clienteService;

    @Test
    void deveListarCliente (){
        clienteService = new ClienteService();
        Long id = 3L;
        String nome = "Kadichari";
        String telefone = "279999999999";
        String email = "limakadichari@gmail.com";
        String cpf = "11111111111" ;
        String endereco = "Rua 1";
        Cliente c = new Cliente(id,nome,telefone, email,cpf,endereco);

        List<Cliente> listaClientes = new ArrayList();
        listaClientes.add(c);

        List<Cliente> clientes = clienteService.getCliente();

        Assertions.assertEquals(listaClientes, clientes);


    }
}
