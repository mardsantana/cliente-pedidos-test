package br.com.clientepedidos.clientepedidos.autenticacao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoApplicationService implements AutenticacaoService{

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @Override
    public Token autentica(UsernamePasswordAuthenticationToken senhaToken) {
        log.info("[start] AutenticacaoApplicationService - autentica");
        var authentication = authenticationManager.authenticate(senhaToken);
        Token token = Token.builder()
                .tipo("Bearer")
                .token(tokenService.gerarToken(authentication))
                .build();
        log.info("[finish] AutenticacaoApplicationService - autentica");
        return token;
    }
}
