package br.edu.ifsul.cstsi.tads_luigiloeck.carros;

import br.edu.ifsul.cstsi.tads_luigiloeck.acessorios.Acessorio;
import br.edu.ifsul.cstsi.tads_luigiloeck.alugueis.Aluguel;
import br.edu.ifsul.cstsi.tads_luigiloeck.modelosCarros.ModeloCarro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "Carro")
@Table(name = "carros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Carro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    @OneToMany(mappedBy = "carro",fetch = FetchType.EAGER)
    private List<Aluguel> alugueis;
    @ManyToMany
    @JoinTable(
            name = "carros_acessorios",
            joinColumns = @JoinColumn(name = "carro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id", referencedColumnName = "id")
    )
    private List<Acessorio> acessorios;
    @ManyToOne
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    private ModeloCarro modelo;
}
