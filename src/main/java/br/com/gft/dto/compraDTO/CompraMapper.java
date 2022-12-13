package br.com.gft.dto.compraDTO;

import br.com.gft.dto.fornecedorDTO.FornecedorMapper;
import br.com.gft.dto.itemCompraDTO.ConsultaItemCompraDTO;
import br.com.gft.dto.itemCompraDTO.ItemCompraMapper;
import br.com.gft.entities.Compra;
import br.com.gft.entities.Fornecedor;
import br.com.gft.entities.ItemCompra;

import java.util.List;

public class CompraMapper {

    public static Compra fromDTO(RegistroCompraDTO dto) {
        List<ItemCompra> listaItensCompra = dto.getItens()
                .stream().map(i-> ItemCompraMapper.fromDTO(i)).toList();

          return new Compra(null, null,  listaItensCompra, new Fornecedor(dto.getFornecedorId()));

    }


    public static ConsultaCompraDTO fromEntity(Compra compra) {
        List<ConsultaItemCompraDTO> listaItensCompra = compra.getItens()
                .stream().map(i -> ItemCompraMapper.fromEntity(i)).toList();

        return new ConsultaCompraDTO(compra.getId(), listaItensCompra, compra.getValorTotal(),
                FornecedorMapper.fromEntity(compra.getFornecedor()));


    }


}
