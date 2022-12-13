package br.com.gft.dto.itemCompraDTO;

import br.com.gft.dto.itemVendaDTO.ConsultaItemVendaDTO;

import br.com.gft.entities.*;

public class ItemCompraMapper {

    public static ItemCompra fromDTO (RegistroItemCompraDTO DTO) {
        return new ItemCompra(null, new Produto(DTO.getProduto_id()),DTO.getQuantidade(), DTO.getValor(),
                0);
    }

    public static ConsultaItemCompraDTO fromEntity (ItemCompra itemCompra){
        return new ConsultaItemCompraDTO(itemCompra.getId(), itemCompra.getProduto(), itemCompra.getQuantidade());
    }
}
