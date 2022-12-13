package br.com.gft.services;

import br.com.gft.entities.ItemVenda;
import br.com.gft.entities.Venda;
import br.com.gft.repositories.ItemVendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;
    private final ProdutoService produtoService;

    public ItemVenda salvarItemVenda(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);

    }

    public List<ItemVenda> buscarInformacoesDoProduto(Venda venda){
        return venda.getItens()
                .stream()
                .map(i->salvarItemVenda(
                        new ItemVenda(i.getId(),
                                produtoService.buscarProdutoPorId(i.getProduto().getId()),
                                i.getQuantidade(),i.getValorVenda(), new BigDecimal("0.0")))).toList();
    }


}








