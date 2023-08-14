package br.com.clientepedidos.clientepedidos.autenticacao;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import javax.validation.Valid;

@RequestMapping("/autenticacao")
public interface AutenticacaoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    TokenResponse autentica(@RequestBody @Valid AutenticacaoRequest autenticacaoRequest) throws AuthenticationException;

}
