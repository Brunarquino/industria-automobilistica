package br.com.gft.services;

import br.com.gft.entities.Compra;
import br.com.gft.entities.ItemCompra;
import br.com.gft.entities.Produto;
import br.com.gft.repositories.ItemCompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@AllArgsConstructor
@Service
public class ItemCompraService {

    private final ItemCompraRepository itemCompraRepository;
    private final ProdutoService produtoService;

    public ItemCompra salvarItemCompra(ItemCompra itemCompra) {
        return itemCompraRepository.save(itemCompra);

    }

    public List<ItemCompra> buscarItensProdutoPeloProdutoEMaioresQueZero(Produto produto){
        return itemCompraRepository.findByProdutoAndQuantidadeDeItensDisponiveisParaVendaGreaterThan
                (produto, 0);
    }

    public List<ItemCompra> buscarInformacoesDoProduto(Compra compra){
        return compra.getItens()
                .stream()
                .map(i->salvarItemCompra(
                        new ItemCompra(i.getId(),
                                produtoService.buscarProdutoPorId(i.getProduto().getId()),
                                i.getQuantidade(),i.getValorCompra(), i.getQuantidade()))).toList();
    }

}
