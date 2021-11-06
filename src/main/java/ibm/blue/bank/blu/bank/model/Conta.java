package ibm.blue.bank.blu.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_CONTA")
public class Conta implements Serializable {
    private static  final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NUMERO")
    private int numero;
    @Column(name = "DIGITO")
    private int digito;
    @Column(name = "SALDO")
    private double saldo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CLIENTE_ID" , referencedColumnName = "ID")
    @NonNull
    private Cliente cliente;


    public Conta(Long id, int numero, int digito, double saldo, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.cliente = cliente;

    }
    
    
}
