package br.com.gft.dto.vendaDTO;


import br.com.gft.dto.clienteDTO.ConsultaClienteDTO;
import br.com.gft.entities.ItemVenda;
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
public class ConsultaVendaDTO {

    private Long id;
    private ConsultaClienteDTO cliente;
    private List<ItemVenda> itens;
    private BigDecimal valorTotal;
    private BigDecimal lucroPorVenda;
}
