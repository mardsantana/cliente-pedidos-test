package br.com.clientepedidos.clientepedidos.autenticacao;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AutenticacaoService {
    Token autentica(UsernamePasswordAuthenticationToken senhaToken);
}
