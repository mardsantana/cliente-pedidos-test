package br.com.clientepedidos.clientepedidos.credencial.application.service;


import br.com.clientepedidos.clientepedidos.cliente.api.ClienteNovoRequest;
import br.com.clientepedidos.clientepedidos.credencial.application.repository.CredencialRepository;
import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialService implements CredencialApplicationService {
	private final CredencialRepository credencialRepository;
	
	@Override
	public void criaNovaCredencial(@Valid ClienteNovoRequest clienteNovoRequest) {
		log.info("[start] CrendencialService - criaNovaCredencial");
		var novaCredencial = new Credencial(clienteNovoRequest.getEmail(), clienteNovoRequest.getSenha());
		credencialRepository.salva(novaCredencial);
		log.info("[finish] CrendencialService - criaNovaCredencial");
	}
	
	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[inicia] CredencialSpringDataJpaService - buscaCredencial");
		Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
		log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencial");
		return credencial;
	}
}
