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
import java.util.UUID;

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
    @Override
    public Entregas buscaEntregaPorID(UUID idEntregas) {
        log.info("[start] EntregasInfraRepository - buscaEntregaPorID");
        Entregas entregas = entregasSpringDataJPARepository.findById(idEntregas)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Entrega Não Encontrada!!"));
        log.info("[finish] EntregasInfraRepository - buscaEntregaPorID");
        return entregas;
    }
    @Override
    public void deleteEntrega(Entregas entregas) {
        log.info("[start] EntregasInfraRepository - deleteEntrega");
        entregasSpringDataJPARepository.delete(entregas);
        log.info("[finish] EntregasInfraRepository - deleteEntrega");
    }
}