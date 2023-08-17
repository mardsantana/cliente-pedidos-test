package br.com.clientepedidos.clientepedidos.autenticacao.application.api;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/autenticacao")
public interface AutenticacaoAPI {
    @PostMapping
    TokenResponse autentica(@RequestBody @Valid AutenticacaoRequest autenticacaoRequest) throws AuthenticationException;

}
