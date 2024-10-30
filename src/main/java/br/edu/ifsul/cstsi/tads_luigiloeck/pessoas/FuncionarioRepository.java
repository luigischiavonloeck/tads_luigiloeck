package br.edu.ifsul.cstsi.tads_luigiloeck.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}