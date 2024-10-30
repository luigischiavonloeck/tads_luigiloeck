package br.edu.ifsul.cstsi.tads_luigiloeck.alugueis;

import br.edu.ifsul.cstsi.tads_luigiloeck.apolices.ApoliceSeguro;
import br.edu.ifsul.cstsi.tads_luigiloeck.carros.Carro;
import br.edu.ifsul.cstsi.tads_luigiloeck.pessoas.Motorista;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "alugueis")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluguel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista_id", referencedColumnName = "id")
    private Motorista motorista;
    @Embedded
    private ApoliceSeguro apolice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id", referencedColumnName = "id")
    private Carro carro;

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
