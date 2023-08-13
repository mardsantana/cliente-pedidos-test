package br.com.clientepedidos.clientepedidos.cliente.infra;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
   Optional<Cliente> findByNome(String nome);
}
