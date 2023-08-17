package br.com.clientepedidos.clientepedidos.autenticacao.application.service;

import br.com.clientepedidos.clientepedidos.autenticacao.domain.Token;
import br.com.clientepedidos.clientepedidos.config.security.service.TokenService;
import br.com.clientepedidos.clientepedidos.credencial.application.service.CredencialApplicationService;
import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;
import br.com.clientepedidos.clientepedidos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoService implements AutenticacaoApplicationService {
    private  AuthenticationManager authenticationManager;
    private  TokenService tokenService;

    @Override
    public Token autentica(UsernamePasswordAuthenticationToken userCredentials) {
        log.info("[inicio] AutenticacaoService - autentica");
        var authentication = authenticationManager.authenticate(userCredentials);
        Token token = Token.builder()
                .tipo("Bearer")
                .token(tokenService.gerarToken(authentication))
                .build();
        log.info("[finaliza] AutenticacaoService - autentica");
        return token;
    }

    private String extraiUsuario(String tokenExpirado){
        return tokenService.getUsuario(tokenExpirado)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Token Invalido!"));
    }
}
