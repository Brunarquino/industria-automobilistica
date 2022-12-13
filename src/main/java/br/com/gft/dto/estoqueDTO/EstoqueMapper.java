package br.com.gft.dto.estoqueDTO;

import br.com.gft.entities.Estoque;

public class EstoqueMapper {

    public static ConsultaEstoqueDTO fromEntity(Estoque estoque){

        return new ConsultaEstoqueDTO(estoque.getId(), estoque.getProduto(), estoque.getQuantidade());

    }

}
