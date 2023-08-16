package br.com.clientepedidos.clientepedidos.credencial.application.service;


import br.com.clientepedidos.clientepedidos.cliente.api.ClienteNovoRequest;
import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;

import javax.validation.Valid;

public interface CredencialApplicationService {
	void criaNovaCredencial(@Valid ClienteNovoRequest clienteNovoRequest);
	Credencial buscaCredencialPorUsuario(String usuario);
}
