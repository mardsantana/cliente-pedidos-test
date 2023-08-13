package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosListResponse;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosRequest;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosResponse;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import br.com.clientepedidos.clientepedidos.pedidos.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
public class PedidosApplicationService implements PedidosService {

    private final PedidosRepository pedidosRepository;

    @Override
    public PedidosResponse criaPedidos(PedidosRequest pedidosRequest) {
        log.info("[start] PedidosApplicationService - criaPedidos");
        Pedidos pedidos = pedidosRepository.savePedidos(new Pedidos(pedidosRequest));
        log.info("[finsih] PedidosApplicationService - criaPedidos");
        return PedidosResponse.builder().idPedidos(pedidos.getIdPedidos()).build();
    }
    @Override
    public List<PedidosListResponse> buscaPedidosGerais() {
        log.info("[start] PedidosApplicationService - buscaPorNumeroPedidos");
        List<Pedidos> pedidos = pedidosRepository.buscaPedidosGerais();
        log.info("[finish] PedidosApplicationService - buscaPorNumeroPedidos");
        return PedidosListResponse.converte(pedidos);
    }
    @Override
    public PedidosListResponse buscaPorNumeroPedidos(Integer numeroPedido) {
        log.info("[start] PedidosApplicationService - buscaPorNumeroPedidos");
        Pedidos pedidos = pedidosRepository.buscaPorNumeroPedidos(numeroPedido);
        log.info("[finish] PedidosApplicationService - buscaPorNumeroPedidos");
        return new PedidosListResponse(pedidos);
    }
    @Override
    public void alteraPedido(Integer numeroPedido, PedidosAlteracaoRequest pedidosAlteracaoRequest) {
        log.info("[start] PedidosApplicationService - alteraPedido");
        Pedidos pedidos = pedidosRepository.buscaPorNumeroPedidos(numeroPedido);
        pedidos.altera(pedidosAlteracaoRequest);
        pedidosRepository.savePedidos(pedidos);
        log.info("[finish] PedidosApplicationService - alteraPedido");
    }
    @Override
    public void deletePorNumeroPedido(Integer numeroPedido) {
        log.info("[start] PedidosApplicationService - deletePorNumeroPedido");
        Pedidos pedidos = pedidosRepository.buscaPorNumeroPedidos(numeroPedido);
        pedidosRepository.deletePedido(pedidos);
        log.info("[finish] PedidosApplicationService - deletePorNumeroPedido");
    }
}