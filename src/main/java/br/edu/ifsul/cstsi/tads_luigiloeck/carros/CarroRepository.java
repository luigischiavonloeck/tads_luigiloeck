package br.edu.ifsul.cstsi.tads_luigiloeck.carros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarroRepository extends JpaRepository<Carro, Long> {
  }