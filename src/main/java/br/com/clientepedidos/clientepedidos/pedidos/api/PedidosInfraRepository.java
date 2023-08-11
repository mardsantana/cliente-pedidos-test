package br.com.clientepedidos.clientepedidos.pedidos.api;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidosInfraRepository implements PedidosRepository{

    private final PedidosSpringDataJPARepository pedidosSpringDataJPARepository;

    //O método em questão Cria e Salva os Pedidos
    @Override
    public Pedidos savePedidos(Pedidos pedidos) {
        log.info("[start] PedidosInfraRepository - savePedidos");
        pedidosSpringDataJPARepository.save(pedidos);
        log.info("[finish] PedidosInfraRepository - savePedidos");
        return pedidos;
    }
    //O método em questão, busca e lista o pedido pelo número do pedido
    @Override
    public List<Pedidos> buscaPorNumeroPedidos() {
        log.info("[start] PedidosInfraRepository - buscaPorNumeroPedidos");
        List<Pedidos> pedidos = pedidosSpringDataJPARepository.findAll();
        log.info("[finish] PedidosInfraRepository - buscaPorNumeroPedidos");
        return pedidos;
    }
}
