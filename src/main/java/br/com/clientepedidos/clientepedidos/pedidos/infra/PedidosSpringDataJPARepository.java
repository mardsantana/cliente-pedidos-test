package br.com.clientepedidos.clientepedidos.pedidos.infra;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;

public interface PedidosSpringDataJPARepository extends JpaRepository<Pedidos, UUID> {

    Optional<Object> findByNumeroPedido(Integer numeroPedido);
}
