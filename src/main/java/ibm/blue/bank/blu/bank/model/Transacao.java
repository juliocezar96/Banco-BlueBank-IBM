package ibm.blue.bank.blu.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "TB_TRANSACAO")
public class Transacao implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATA")
    private Date data;
    @Column(name = "VALOR")
    private Double valor;
    @OneToOne
    @JoinColumn(name="CONTA_DESTINO_ID")
    private Conta contaDestino;
    @OneToOne
    @JoinColumn(name="CONTA_ORIGEM_ID", referencedColumnName = "ID")
    private Conta contaOrigem ;

}