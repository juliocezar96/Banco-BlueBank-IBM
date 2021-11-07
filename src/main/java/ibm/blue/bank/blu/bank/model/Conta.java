package ibm.blue.bank.blu.bank.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CONTA")
public class Conta implements Serializable {
    private static  final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotNull
    @Column(name = "NUMERO")
    private Long numero;
    @NotNull
    @Column(name = "DIGITO")
    private Long digito;
    @NotNull
    @Column(name = "SALDO")
    private Double saldo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CLIENTE_ID" , referencedColumnName = "ID")
    @NotNull
    private Cliente cliente;

}
