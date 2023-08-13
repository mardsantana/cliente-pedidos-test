package br.com.clientepedidos.clientepedidos.entregas.infra;

import br.com.clientepedidos.clientepedidos.entregas.domain.Entregas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntregasSpringDataJPARepository extends JpaRepository<Entregas, UUID> {
}
