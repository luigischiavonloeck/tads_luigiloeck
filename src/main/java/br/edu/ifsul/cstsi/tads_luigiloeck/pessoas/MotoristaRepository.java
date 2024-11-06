package br.edu.ifsul.cstsi.tads_luigiloeck.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MotoristaRepository extends JpaRepository<Motorista,Long> {
    List<Motorista> findByNome(String nome);

    Motorista findByNumeroCNH(String numeroCNH);

    List<Motorista> findBySexo(Sexo sexo);
}
