package br.edu.ifsul.cstsi.tads_luigiloeck.apolices;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class ApoliceSeguro {
    private BigDecimal valorFranquia;
    private Boolean protecaoTerceiro;
    private Boolean protecaoCausasNaturais;
    private Boolean protecaoRoubo;
}
