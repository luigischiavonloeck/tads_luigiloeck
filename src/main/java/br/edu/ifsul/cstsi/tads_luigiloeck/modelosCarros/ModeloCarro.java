package br.edu.ifsul.cstsi.tads_luigiloeck.modelosCarros;

import br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes.Fabricante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "modelos_carros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModeloCarro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "fabricante_id", referencedColumnName = "id")
    private Fabricante fabricante;
}
