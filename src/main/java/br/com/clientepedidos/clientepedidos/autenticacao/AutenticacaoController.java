package br.com.clientepedidos.clientepedidos.autenticacao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoController implements AutenticacaoAPI{
    private final AutenticacaoService autenticacaoService;
    @Override
    public TokenResponse autentica(AutenticacaoRequest autenticacaoRequest) throws AuthenticationException {
        log.info("[start] Iniciando metodo autenticacao em AutenticacaoController");
        var token = autenticacaoService.autentica(autenticacaoRequest.getSenhaToken());
        return new TokenResponse(token);
    }
}