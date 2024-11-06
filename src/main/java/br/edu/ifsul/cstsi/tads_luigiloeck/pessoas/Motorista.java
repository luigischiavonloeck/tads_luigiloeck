package br.edu.ifsul.cstsi.tads_luigiloeck.pessoas;

import br.edu.ifsul.cstsi.tads_luigiloeck.alugueis.Aluguel;
import br.edu.ifsul.cstsi.tads_luigiloeck.pessoas.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@Entity(name = "Motorista")
@PrimaryKeyJoinColumn(name = "pessoa_id")
@Table(name = "motoristas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Motorista extends Pessoa {
    private String numeroCNH;
    @OneToMany(mappedBy = "motorista",fetch = FetchType.EAGER)
    private List<Aluguel> alugueis;
}
