package br.com.gft.dto.veiculoDTO;
import br.com.gft.dto.pecaDTO.ConsultaPecaDTO;
import br.com.gft.entities.Produto;
import br.com.gft.enuns.StatusVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaVeiculoDTO {

    private Long id;
    private Produto produto;
    private StatusVeiculo status;
    private BigDecimal valorInsumo;
    private List<ConsultaPecaDTO> pecas;

}
