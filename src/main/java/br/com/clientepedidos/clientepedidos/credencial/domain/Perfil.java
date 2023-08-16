package br.com.clientepedidos.clientepedidos.credencial.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Perfil implements GrantedAuthority {
	@Getter
	private String nome;

	@Override
	public String getAuthority() {
		return this.nome;
	}

	private static final long serialVersionUID = 1L;
}
