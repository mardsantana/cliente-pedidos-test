package br.com.clientepedidos.clientepedidos.cliente.application.infra;

import br.com.clientepedidos.clientepedidos.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {

//    Optional<Object> findByNome(String nomeCompleto);
}
