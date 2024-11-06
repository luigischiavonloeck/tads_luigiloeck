package br.edu.ifsul.cstsi.tads_luigiloeck.acessorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
}