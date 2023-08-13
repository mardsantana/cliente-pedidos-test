package br.com.clientepedidos.clientepedidos.entregas;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente/entregas")
@Log4j2
@RequiredArgsConstructor
public class EntregasController {

    private final EntregasService entregasService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EntregasResponse postEntregas(@Valid @RequestBody EntregasRequest entregasRequest) {
        log.info("[start] EntregasController - postEntregas");
        EntregasResponse entregasCriado = entregasService.criaEntregas(entregasRequest);
        log.info("[finish] EntregasController - postEntregas");
        return entregasCriado;
    }

}
