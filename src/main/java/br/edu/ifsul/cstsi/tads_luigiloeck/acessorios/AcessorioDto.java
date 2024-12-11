package br.edu.ifsul.cstsi.tads_luigiloeck.acessorios;

import java.io.Serializable;

/**
 * DTO for {@link br.edu.ifsul.cstsi.tads_luigiloeck.acessorios.Acessorio}
 */
public record AcessorioDto(String descricao) implements Serializable {
    public AcessorioDto(Acessorio acessorio) {
        this(acessorio.getDescricao());
    }

    public Acessorio toAcessorio() {
        return new Acessorio(null, descricao, null);
    }
}