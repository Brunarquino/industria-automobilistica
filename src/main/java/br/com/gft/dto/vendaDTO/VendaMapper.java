package br.com.gft.dto.vendaDTO;

import br.com.gft.dto.clienteDTO.ClienteMapper;
import br.com.gft.entities.*;

import java.util.List;

public class VendaMapper {

    public static Venda fromDTO(RegistroVendaDTO dto) {
        List<ItemVenda> listaItensVenda = dto.getItens()
                .stream()
                .map(i -> new ItemVenda(null, new Produto(i.getProduto_id()),i.getQuantidade(),i.getValor(),null)).toList();
        return new Venda(null, null, listaItensVenda, new Cliente(dto.getClienteId()));
    }

    public static ConsultaVendaDTO fromEntity(Venda venda) {
        return new ConsultaVendaDTO(venda.getId(), ClienteMapper.fromEntity(venda.getCliente()),
                venda.getItens(),venda.getValorTotal(), venda.getLucroPorVenda());
    }


}
