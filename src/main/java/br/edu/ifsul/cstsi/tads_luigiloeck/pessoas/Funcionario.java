package br.edu.ifsul.cstsi.tads_luigiloeck.pessoas;

import br.edu.ifsul.cstsi.tads_luigiloeck.pessoas.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario extends Pessoa {
    private String matricula;
}
