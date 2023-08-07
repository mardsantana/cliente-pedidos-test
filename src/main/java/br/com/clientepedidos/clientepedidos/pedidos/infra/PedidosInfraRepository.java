package br.com.clientepedidos.clientepedidos.pedidos.infra;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import br.com.clientepedidos.clientepedidos.pedidos.repository.PedidosRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidosInfraRepository implements PedidosRespository {

    private final PedidosSpringDataJPARepository pedidosSpringDataJPARepository;
    @Override
    public Pedidos savePedidos(Pedidos pedidos) {
        log.info("[start] PedidosInfraRepository - savePedidos");
        pedidosSpringDataJPARepository.save(pedidos);
        log.info("[finish] PedidosInfraRepository - savePedidos");
        return pedidos;
    }
}
