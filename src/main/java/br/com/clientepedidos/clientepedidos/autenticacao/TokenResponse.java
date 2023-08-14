package br.com.clientepedidos.clientepedidos.autenticacao;

import lombok.Value;

@Value
public class TokenResponse {
    private String token;

    public TokenResponse(Token token) {
        this.token = token.getToken();
    }
}
