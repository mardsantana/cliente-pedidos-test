package br.com.clientepedidos.clientepedidos.pedidos.infra;
import br.com.clientepedidos.clientepedidos.handler.APIException;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import br.com.clientepedidos.clientepedidos.pedidos.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidosInfraRepository implements PedidosRepository {

    private final PedidosSpringDataJPARepository pedidosSpringDataJPARepository;

    @Override
    public Pedidos savePedidos(Pedidos pedidos) {
        log.info("[start] PedidosInfraRepository - savePedidos");
        pedidosSpringDataJPARepository.save(pedidos);
        log.info("[finish] PedidosInfraRepository - savePedidos");
        return pedidos;
    }
    @Override
    public List<Pedidos> buscaPedidosGerais() {
        log.info("[start] PedidosInfraRepository - buscaPorNumeroPedidos");
        List<Pedidos> pedidosGerais = pedidosSpringDataJPARepository.findAll();
        log.info("[finish] PedidosInfraRepository - buscaPorNumeroPedidos");
        return pedidosGerais;
    }
    @Override
    public Pedidos buscaPorNumeroPedidos(Integer numeroPedido) {
        log.info("[start] PedidosInfraRepository - buscaPorNumeroPedidos");
        Pedidos pedidos = (Pedidos) pedidosSpringDataJPARepository.findByNumeroPedido(numeroPedido)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pedido Não Encontrado!!"));
        log.info("[finish] PedidosInfraRepository - buscaPorNumeroPedidos");
        return pedidos;
    }
    @Override
    public void deletePedido(Pedidos pedidos) {
        log.info("[start] PedidosInfraRepository - deletePedido");
        pedidosSpringDataJPARepository.delete(pedidos);
        log.info("[finish] PedidosInfraRepository - deletePedido");
    }
}
