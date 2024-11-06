package br.edu.ifsul.cstsi.tads_luigiloeck.modelosCarros;

import br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
    List<ModeloCarro> findByDescricao(String descricao);
}