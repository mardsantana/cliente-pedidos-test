package br.com.clientepedidos.clientepedidos.entregas.repository;


import br.com.clientepedidos.clientepedidos.entregas.domain.Entregas;

import java.util.List;

public interface EntregasRepository {
    Entregas saveEntregas(Entregas entregas);
    List<Entregas> buscaEntregasGerais();
}
