package ibm.blue.bank.blu.bank.repository;

import ibm.blue.bank.blu.bank.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long>{
  
}
