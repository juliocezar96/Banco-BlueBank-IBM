package ibm.blue.bank.blu.bank.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente", fetch = FetchType.EAGER)
    private Conta conta;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente", fetch = FetchType.EAGER)
    private Agencia agencia;


}
