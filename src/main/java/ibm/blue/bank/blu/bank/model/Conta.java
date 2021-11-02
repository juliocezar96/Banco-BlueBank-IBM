package ibm.blue.bank.blu.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Conta {

    private Long id;
    private int numero;
    private int digito;
    @OneToOne
    @JoinColumn(name = "agencia_id")
    private Agencia agencia;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


}
