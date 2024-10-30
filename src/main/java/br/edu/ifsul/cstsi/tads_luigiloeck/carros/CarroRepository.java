package br.edu.ifsul.cstsi.tads_luigiloeck.carros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
  }