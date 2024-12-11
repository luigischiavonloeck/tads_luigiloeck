package br.edu.ifsul.cstsi.tads_luigiloeck.alugueis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * DTO for {@link br.edu.ifsul.cstsi.tads_luigiloeck.alugueis.Aluguel}
 */
public record AluguelDto(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, BigDecimal valorFranquia, Boolean protecaoTerceiro, Boolean protecaoCausasNaturais, Boolean protecaoRoubo) implements Serializable {
    public AluguelDto(Aluguel aluguel) {
        this(aluguel.getDataPedido(), aluguel.getDataEntrega(), aluguel.getDataDevolucao(), aluguel.getValorTotal(), aluguel.getValorFranquia(), aluguel.getProtecaoTerceiro(), aluguel.getProtecaoCausasNaturais(), aluguel.getProtecaoRoubo());
    }

    public Aluguel toAluguel() {
        return new Aluguel(null, dataPedido, dataEntrega, dataDevolucao, valorTotal, valorFranquia, protecaoTerceiro, protecaoCausasNaturais, protecaoRoubo, null, null);
    }
}