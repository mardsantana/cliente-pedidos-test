package br.com.clientepedidos.clientepedidos.entregas.service;

import br.com.clientepedidos.clientepedidos.entregas.api.EntregasListResponse;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasRequest;
import br.com.clientepedidos.clientepedidos.entregas.api.EntregasResponse;

import java.util.List;

public interface EntregasService {
    EntregasResponse criaEntregas(EntregasRequest entregasRequest);
    List<EntregasListResponse> buscaEntregasGerais();
}
