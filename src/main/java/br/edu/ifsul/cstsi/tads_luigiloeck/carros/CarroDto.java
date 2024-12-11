package br.edu.ifsul.cstsi.tads_luigiloeck.carros;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link br.edu.ifsul.cstsi.tads_luigiloeck.carros.Carro}
 */
public record CarroDto(String placa, String chassi, String cor, BigDecimal valorDiaria) implements Serializable {
    public CarroDto(Carro carro) {
        this(carro.getPlaca(), carro.getChassi(), carro.getCor(), carro.getValorDiaria());
    }

    public Carro toCarro() {
        return new Carro(null, placa, chassi, cor, valorDiaria, null, null, null);
    }
}