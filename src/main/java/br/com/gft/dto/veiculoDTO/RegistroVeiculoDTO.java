package br.com.gft.dto.veiculoDTO;

import br.com.gft.dto.pecaDTO.RegistroPecaDTO;
import br.com.gft.enuns.StatusVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroVeiculoDTO {

    private String nome;
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;
    private BigDecimal valorInsumo;
    private List<Long> pecasId;
}
