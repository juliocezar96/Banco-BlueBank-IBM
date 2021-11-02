package ibm.blue.bank.blu.bank.repository;

import ibm.blue.bank.blu.bank.model.Cliente;
import ibm.blue.bank.blu.bank.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
