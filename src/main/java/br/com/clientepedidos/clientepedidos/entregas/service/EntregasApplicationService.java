package br.com.clientepedidos.clientepedidos.entregas.service;


import br.com.clientepedidos.clientepedidos.entregas.api.EntregasListResponse;
import br.com.clientepedidos.clientepedidos.entregas.repository.EntregasRepository;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasRequest;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasResponse;
import br.com.clientepedidos.clientepedidos.entregas.domain.Entregas;
import br.com.clientepedidos.clientepedidos.pedidos.api.PedidosListResponse;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class EntregasApplicationService implements EntregasService {

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
}
