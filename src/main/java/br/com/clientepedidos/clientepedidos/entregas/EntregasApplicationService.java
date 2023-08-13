package br.com.clientepedidos.clientepedidos.entregas;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class EntregasApplicationService implements EntregasService{

    private final EntregasRepository entregasRepository;

    @Override
    public EntregasResponse criaEntregas(EntregasRequest entregasRequest) {
        log.info("[start] EntregasApplicationService - criaEntregas");
        Entregas entregas = entregasRepository.saveEntregas(new Entregas(entregasRequest));
        log.info("[finish] EntregasApplicationService - criaEntregas");
        return EntregasResponse.builder().idEntregas(entregas.getIdEntregas()).build();
    }
}

