package br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes.Fabricante}
 */
public record FabricanteDto(String nome) implements Serializable {
    public FabricanteDto(Fabricante fabricante) {
        this(fabricante.getNome());
    }

    public Fabricante toFabricante() {
        return new Fabricante(null, nome);
    }
}