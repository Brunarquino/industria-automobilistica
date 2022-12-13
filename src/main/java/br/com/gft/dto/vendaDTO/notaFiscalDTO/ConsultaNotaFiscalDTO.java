package br.com.gft.dto.vendaDTO.notaFiscalDTO;

import br.com.gft.dto.clienteDTO.ConsultaClienteDTO;
import br.com.gft.dto.fornecedorDTO.ConsultaFornecedorDTO;
import br.com.gft.dto.itemVendaDTO.ConsultaItemVendaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConsultaNotaFiscalDTO {

    private Long id;
    private ConsultaClienteDTO cliente;
    private ConsultaFornecedorDTO fornecedor;
    private List<ConsultaItemVendaDTO> itens;
    private BigDecimal valorTotal;

}
