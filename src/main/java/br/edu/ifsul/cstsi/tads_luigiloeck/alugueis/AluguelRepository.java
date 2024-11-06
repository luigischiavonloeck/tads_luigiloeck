package br.edu.ifsul.cstsi.tads_luigiloeck.alugueis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
}
