package br.com.clientepedidos.clientepedidos.entregas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntregasSpringDataJPARepository extends JpaRepository<Entregas, UUID> {
}
