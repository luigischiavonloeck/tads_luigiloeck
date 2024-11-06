package br.edu.ifsul.cstsi.tads_luigiloeck.alugueis;

import br.edu.ifsul.cstsi.tads_luigiloeck.carros.Carro;
import br.edu.ifsul.cstsi.tads_luigiloeck.pessoas.Motorista;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "Aluguel")
@Table(name = "alugueis")
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
    private BigDecimal valorFranquia;
    private Boolean protecaoTerceiro;
    private Boolean protecaoCausasNaturais;
    private Boolean protecaoRoubo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista_id", referencedColumnName = "id")
    private Motorista motorista;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id", referencedColumnName = "id")
    private Carro carro;
}
