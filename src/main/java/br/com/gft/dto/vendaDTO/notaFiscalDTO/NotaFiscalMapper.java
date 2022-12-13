package br.com.gft.dto.vendaDTO.notaFiscalDTO;

import br.com.gft.dto.clienteDTO.ClienteMapper;
import br.com.gft.dto.fornecedorDTO.FornecedorMapper;
import br.com.gft.dto.itemVendaDTO.ConsultaItemVendaDTO;
import br.com.gft.dto.itemVendaDTO.ItemVendaMapper;
import br.com.gft.entities.NotaFiscal;

import java.util.List;

public class NotaFiscalMapper {

    public static ConsultaNotaFiscalDTO fromEntity(NotaFiscal notaFiscal) {
        List<ConsultaItemVendaDTO> itensVenda =
                notaFiscal.getItens().stream().map(ItemVendaMapper::fromEntity).toList();

        return new ConsultaNotaFiscalDTO(notaFiscal.getId(), ClienteMapper.fromEntity(notaFiscal.getCliente()),
                FornecedorMapper.fromEntity(notaFiscal.getFornecedor()), itensVenda, notaFiscal.getValorTotal());
    }
}
