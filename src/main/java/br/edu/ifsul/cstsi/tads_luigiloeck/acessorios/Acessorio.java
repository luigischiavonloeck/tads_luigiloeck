package br.edu.ifsul.cstsi.tads_luigiloeck.acessorios;

import br.edu.ifsul.cstsi.tads_luigiloeck.carros.Carro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Acessorio")
@Table(name = "acessorios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Acessorio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;
}
