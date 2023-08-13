package br.com.clientepedidos.clientepedidos.entregas.repository;


import br.com.clientepedidos.clientepedidos.entregas.domain.Entregas;

import java.util.List;
import java.util.UUID;

public interface EntregasRepository {
    Entregas saveEntregas(Entregas entregas);
    List<Entregas> buscaEntregasGerais();
    Entregas buscaEntregaPorID(UUID idEntregas);
    void deleteEntrega(Entregas entregas);
}
