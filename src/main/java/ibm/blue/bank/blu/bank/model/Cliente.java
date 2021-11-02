package ibm.blue.bank.blu.bank.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "TB_CLIENTE")
public class Cliente implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente",targetEntity = Conta.class, fetch = FetchType.EAGER)
    @JoinColumn(name="CONTA_ID")
    private Conta conta;


}
