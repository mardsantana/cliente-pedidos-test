package br.com.clientepedidos.clientepedidos.entregas;


import br.com.clientepedidos.clientepedidos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EntregasInfraRepository implements EntregasRepository{

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
}
