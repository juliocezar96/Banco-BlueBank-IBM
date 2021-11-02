package ibm.blue.bank.blu.bank.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@EqualsAndHashCode
@Entity
@Table(name= "TB_TRANSACAO")
public class Transacao implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    private Double valor;
    private int contaDestino;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transacao",targetEntity = Conta.class, fetch = FetchType.EAGER)
    @JoinColumn(name="CONTA_ID")
    private Conta conta;
    
	public Transacao(Long id, String data, Double valor, int contaDestino) {
		super();
		this.id = id;
		this.data = data;
		this.valor = valor;
		this.contaDestino = contaDestino;
	}
    
    
}