package br.com.clientepedidos.clientepedidos.entregas;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Data
@ToString
public class Entregas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEntregas;
    @NotBlank
    private String nomeRua;
    private Integer numeroCasa;
    @NotBlank
    private String referencia;

}
