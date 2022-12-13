package br.com.gft.dto.itemVendaDTO;



import br.com.gft.entities.ItemVenda;
import br.com.gft.entities.Produto;
import br.com.gft.entities.Venda;

import java.math.BigDecimal;

public class ItemVendaMapper {

    public static ItemVenda fromDTO (RegistroItemVendaDTO DTO) {
       return new ItemVenda(null, new Produto(DTO.getProduto_id()),DTO.getQuantidade(), DTO.getValor(),
               new BigDecimal("0.0"));
    }

    public static ConsultaItemVendaDTO fromEntity (ItemVenda itemVenda){
        return new ConsultaItemVendaDTO(itemVenda.getId(), itemVenda.getProduto(), itemVenda.getQuantidade());
    }

}
