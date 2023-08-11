package br.com.clientepedidos.clientepedidos.pedidos.api;

import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
public class PedidosApplicationService implements PedidosService{

    private final PedidosRepository pedidosRepository;

    //O método em questão Cria e Salva os Pedidos
    @Override
    public PedidosResponse criaPedidos(PedidosRequest pedidosRequest) {
        log.info("[start] PedidosApplicationService - criaPedidos");
        Pedidos pedidos = pedidosRepository.savePedidos(new Pedidos(pedidosRequest));
        log.info("[finsih] PedidosApplicationService - criaPedidos");
        return PedidosResponse.builder().idPedidos(pedidos.getIdPedidos()).build();
    }
    //O método em questão, busca e lista o pedido pelo número do pedido
    @Override
    public List<PedidosListResponse> buscaPorNumeroPedidos() {
        log.info("[start] PedidosApplicationService - buscaPorNumeroPedidos");
        List<Pedidos> pedidos = pedidosRepository.buscaPorNumeroPedidos();
        log.info("[finish] PedidosApplicationService - buscaPorNumeroPedidos");
        return PedidosListResponse.converte(pedidos);
    }
}
