package br.edu.ifsul.cstsi.tads_luigiloeck.modelosCarros;

import br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes.FabricanteDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ModeloCarro}
 */
public record ModeloCarroDto(
    String descricao,
    Categoria categoria,
    FabricanteDto fabricante
) implements Serializable {
    public ModeloCarroDto(ModeloCarro modeloCarro) {
        this(
            modeloCarro.getDescricao(),
            modeloCarro.getCategoria(),
            new FabricanteDto(modeloCarro.getFabricante())
        );
    }
}