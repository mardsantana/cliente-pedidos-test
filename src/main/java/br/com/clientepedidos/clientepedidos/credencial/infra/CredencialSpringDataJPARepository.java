package br.com.clientepedidos.clientepedidos.credencial.infra;


import br.com.clientepedidos.clientepedidos.credencial.domain.Credencial;
import br.com.clientepedidos.clientepedidos.login.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CredencialSpringDataJPARepository extends JpaRepository<Credencial, Long> {
	Optional<Credencial> findByUsuario(String usuario);
}
