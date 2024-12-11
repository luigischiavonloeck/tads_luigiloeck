package br.edu.ifsul.cstsi.tads_luigiloeck.carros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByPlaca(String placa);
}