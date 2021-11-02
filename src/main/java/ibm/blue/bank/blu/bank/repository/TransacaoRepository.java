package ibm.blue.bank.blu.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.blue.bank.blu.bank.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long>{
  
}
