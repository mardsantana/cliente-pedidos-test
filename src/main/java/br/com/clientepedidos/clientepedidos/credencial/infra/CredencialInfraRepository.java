package br.com.clientepedidos.clientepedidos.credencial.infra;

import br.com.clientepedidos.clientepedidos.credencial.application.repository.CredencialRepository;
import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;
import br.com.clientepedidos.clientepedidos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CredencialInfraRepository implements CredencialRepository {
	private final CredencialSpringDataJPARepository credencialSpringDataJPARepository;

	@Override
	public Credencial salva(Credencial credencial) {
		log.info("[start] CredencialRepositoryMongoDB - salva");
		credencialSpringDataJPARepository.save(credencial);
		log.info("[finish] CredencialRepositoryMongoDB - salva");
		return credencial;
	}

	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
		var credencial = credencialSpringDataJPARepository.findByUsuario(usuario)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o Usuario informado!"));
		log.info("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
		return credencial;
	}
}

