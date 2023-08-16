package br.com.clientepedidos.clientepedidos.autenticacao.application.api;


import br.com.clientepedidos.clientepedidos.autenticacao.domain.Token;
import lombok.Value;

@Value
public class TokenResponse {
	private String token;
	private String tipo;

	public TokenResponse(Token token) {
		this.token = token.getToken();
		this.tipo = token.getTipo();
	}
}