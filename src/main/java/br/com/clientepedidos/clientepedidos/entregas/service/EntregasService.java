package br.com.clientepedidos.clientepedidos.entregas.service;

import br.com.clientepedidos.clientepedidos.entregas.api.EntregasAlteracaoRequest;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasListResponse;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasRequest;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasResponse;

import java.util.List;
import java.util.UUID;

public interface EntregasService {
    EntregasResponse criaEntregas(EntregasRequest entregasRequest);
    List<EntregasListResponse> buscaEntregasGerais();
    EntregasListResponse buscaEntregaPorID(UUID idEntregas);
    void alteraEntrega(UUID idEntregas, EntregasAlteracaoRequest entregasAlteracaoRequest);
    void deleteEntregasID(UUID idEntregas);
}
