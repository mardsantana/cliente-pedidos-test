package br.com.clientepedidos.clientepedidos.entregas.service;


import br.com.clientepedidos.clientepedidos.entregas.api.EntregasAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasListResponse;
import br.com.clientepedidos.clientepedidos.entregas.repository.EntregasRepository;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasRequest;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasResponse;
import br.com.clientepedidos.clientepedidos.entregas.domain.Entregas;
import br.com.clientepedidos.clientepedidos.pedidos.service.PedidosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class EntregasApplicationService implements EntregasService {

    private final PedidosService pedidosService;

    private final EntregasRepository entregasRepository;

    @Override
    public EntregasResponse criaEntregas(EntregasRequest entregasRequest) {
        log.info("[start] EntregasApplicationService - criaEntregas");
        Entregas entregas = entregasRepository.saveEntregas(new Entregas(entregasRequest));
        log.info("[finish] EntregasApplicationService - criaEntregas");
        return EntregasResponse.builder().idEntregas(entregas.getIdEntregas()).build();
    }
    @Override
    public List<EntregasListResponse> buscaEntregasGerais() {
        log.info("[start] EntregasApplicationService - buscaEntregasGerais");
        List<Entregas> entregasG = entregasRepository.buscaEntregasGerais();
        log.info("[finish] EntregasApplicationService - buscaEntregasGerais");
        return EntregasListResponse.converte(entregasG);
    }
    @Override
    public EntregasListResponse buscaEntregaPorID(UUID idEntregas) {
        log.info("[start] EntregasApplicationService - buscaEntregaPorID");
        Entregas entregas = entregasRepository.buscaEntregaPorID(idEntregas);
        log.info("[finish] EntregasApplicationService - buscaEntregaPorID");
        return new EntregasListResponse(entregas);
    }
    @Override
    public void alteraEntrega(UUID idEntregas, EntregasAlteracaoRequest entregasAlteracaoRequest) {
        log.info("[start] EntregasApplicationService - alteraEntrega");
        Entregas entregas = entregasRepository.buscaEntregaPorID(idEntregas);
        entregas.altera(entregasAlteracaoRequest);
        entregasRepository.saveEntregas(entregas);
        log.info("[finish] EntregasApplicationService - alteraEntrega");
    }
    @Override
    public void deleteEntregasID(UUID idEntregas) {
        log.info("[start] EntregasApplicationService - deleteEntregasID");
        Entregas entregas = entregasRepository.buscaEntregaPorID(idEntregas);
        entregasRepository.deleteEntrega(entregas);
        log.info("[finish] EntregasApplicationService - deleteEntregasID");
    }
}