package br.com.clientepedidos.clientepedidos.autenticacao.application.service;

import br.com.clientepedidos.clientepedidos.autenticacao.domain.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AutenticacaoApplicationService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
    Token reativaToken(String tokenExpirado);
}
