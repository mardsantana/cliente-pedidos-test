package br.com.clientepedidos.clientepedidos.pedidos.service;

import br.com.clientepedidos.clientepedidos.cliente.service.ClienteService;
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
import java.util.UUID;


@Service
@Log4j2
@RequiredArgsConstructor
public class PedidosApplicationService implements PedidosService {

    private final ClienteService clienteService;

    private final PedidosRepository pedidosRepository;

    @Override
    public PedidosResponse criaPedidos(UUID idClientePedidos, PedidosRequest pedidosRequest) {
        log.info("[start] PedidosApplicationService - criaPedidos");
        clienteService.buscaClientePorID(idClientePedidos);
        Pedidos pedidos = pedidosRepository.savePedidos(new Pedidos(idClientePedidos, pedidosRequest));
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
    public PedidosListResponse buscaPorID(UUID idClientePedidos, UUID idPedidos) {
        log.info("[start] PedidosApplicationService - buscaPorID");
        clienteService.buscaClientePorID(idClientePedidos);
        Pedidos pedidos = pedidosRepository.buscaPorID(idPedidos);
        log.info("[finish] PedidosApplicationService - buscaPorID");
        return new PedidosListResponse(pedidos);
    }
    @Override
    public void alteraPedido(UUID idClientePedidos, UUID idPedidos, PedidosAlteracaoRequest pedidosAlteracaoRequest) {
        log.info("[start] PedidosApplicationService - alteraPedido");
        clienteService.buscaClientePorID(idClientePedidos);
        Pedidos pedidos = pedidosRepository.buscaPorID(idPedidos);
        pedidos.altera(pedidosAlteracaoRequest);
        pedidosRepository.savePedidos(pedidos);
        log.info("[finish] PedidosApplicationService - alteraPedido");
    }
    @Override
    public void deletePorID(UUID idClientePedidos, UUID idPedidos) {
        log.info("[start] PedidosApplicationService - deletePorNumeroPedido");
        clienteService.buscaClientePorID(idClientePedidos);
        Pedidos pedidos = pedidosRepository.buscaPorID(idPedidos);
        pedidosRepository.deletePedido(pedidos);
        log.info("[finish] PedidosApplicationService - deletePorNumeroPedido");
    }
}