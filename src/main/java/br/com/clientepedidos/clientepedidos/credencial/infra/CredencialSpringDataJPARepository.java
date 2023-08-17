package br.com.clientepedidos.clientepedidos.credencial.infra;


import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredencialSpringDataJPARepository extends JpaRepository<Credencial, Long> {
	Optional<Credencial> findByUsuario(String usuario);
}