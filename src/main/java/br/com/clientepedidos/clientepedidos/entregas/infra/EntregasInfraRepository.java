package br.com.clientepedidos.clientepedidos.entregas.infra;


import br.com.clientepedidos.clientepedidos.entregas.repository.EntregasRepository;
import br.com.clientepedidos.clientepedidos.entregas.domain.Entregas;
import br.com.clientepedidos.clientepedidos.handler.APIException;
import br.com.clientepedidos.clientepedidos.pedidos.domain.Pedidos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EntregasInfraRepository implements EntregasRepository {

    private final EntregasSpringDataJPARepository entregasSpringDataJPARepository;

    @Override
    public Entregas saveEntregas(Entregas entregas) {
        log.info("[start] EntregasInfraRepository - saveEntregas");
        try {
            entregasSpringDataJPARepository.save(entregas);
        } catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
        }
        log.info("[finish] EntregasInfraRepository - saveEntregas");
        return entregas;
    }
    @Override
    public List<Entregas> buscaEntregasGerais() {
        log.info("[start] EntregasInfraRepository - buscaEntregasGerais");
        List<Entregas> entregasGerais = entregasSpringDataJPARepository.findAll();
        log.info("[finsih] EntregasInfraRepository - buscaEntregasGerais");
        return entregasGerais;
    }
}
