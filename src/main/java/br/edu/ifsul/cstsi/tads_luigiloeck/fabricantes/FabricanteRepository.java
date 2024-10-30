package br.edu.ifsul.cstsi.tads_luigiloeck.fabricantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface FabricanteRepository extends JpaRepository<Fabricante,Long> {
    List<Fabricante> findByNome(String nome);
}
