package ibm.blue.bank.blu.bank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@Entity
@Table(name= "TB_TRANSACAO")
public class Transacao implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private Double valor;
    @OneToOne
    @JoinColumn(name="CONTA_DESTINO_ID")
    private Conta contaDestino;
    @OneToOne
    @JoinColumn(name="CONTA_ID", referencedColumnName = "ID")
    private Conta contaOrigem ;

    public Transacao() {
    }

    public Transacao(Long id, Date data, Double valor, Conta contaDestino, Conta contaOrigem) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.contaDestino = contaDestino;
        this.contaOrigem = contaOrigem;
    }
}