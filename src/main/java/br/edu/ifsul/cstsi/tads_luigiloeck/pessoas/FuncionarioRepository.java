package br.edu.ifsul.cstsi.tads_luigiloeck.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}