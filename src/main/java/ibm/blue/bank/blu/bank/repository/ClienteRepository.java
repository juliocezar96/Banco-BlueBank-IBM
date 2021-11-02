package ibm.blue.bank.blu.bank.repository;

import ibm.blue.bank.blu.bank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
