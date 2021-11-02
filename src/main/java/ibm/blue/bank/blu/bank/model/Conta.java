package ibm.blue.bank.blu.bank.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int digito;
    @OneToOne
    private Cliente cliente;


    public Conta(Long id, int numero, int digito) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
    }
}
