package br.edu.ifsul.cstsi.tads_luigiloeck.infra.exception;

public class TokenInvalidoException extends RuntimeException {
  public TokenInvalidoException(String mensagem) {
    super(mensagem);
  }
}
