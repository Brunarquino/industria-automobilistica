package br.com.gft.dto.compraDTO;

import br.com.gft.dto.fornecedorDTO.ConsultaFornecedorDTO;
import br.com.gft.dto.itemCompraDTO.ConsultaItemCompraDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaCompraDTO {

    private Long id;
    private List<ConsultaItemCompraDTO> itens;
    private BigDecimal valorTotal;
    private ConsultaFornecedorDTO fornecedor;
}
