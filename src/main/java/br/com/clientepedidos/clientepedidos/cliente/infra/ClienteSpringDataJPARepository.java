package br.com.clientepedidos.clientepedidos.cliente.infra;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
}
