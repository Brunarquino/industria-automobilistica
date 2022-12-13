package br.com.gft.services;

import br.com.gft.entities.Estoque;
import br.com.gft.entities.ItemCompra;
import br.com.gft.entities.ItemVenda;
import br.com.gft.entities.Produto;
import br.com.gft.repositories.EstoqueRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final ProdutoService produtoService;
    private final ItemCompraService itemCompraService;

    public void atualizarEstoqueCompra(List<ItemCompra> itens) {
        itens.forEach(i -> acrescentaQuantidadeDeEstoque(i.getProduto().getId(), i.getQuantidade()));
    }
    private void acrescentaQuantidadeDeEstoque(Long produtoId, int quantidade) {
        Optional<Estoque> optionalEstoque = estoqueRepository.findByProduto_Id(produtoId);
        Estoque estoque = new Estoque();
        if(optionalEstoque.isPresent()){
            estoque = optionalEstoque.get();
            estoque.setQuantidade(estoque.getQuantidade()+quantidade);
        } else {
            Produto produto = produtoService.buscarProdutoPorId(produtoId);
            estoque.setProduto(produto);
            estoque.setQuantidade(quantidade);
        }
        estoqueRepository.save(estoque);
    }

    public List<ItemVenda> atualizarEstoqueVenda(List<ItemVenda> itens) {
        List<ItemVenda> itensVendidos = new ArrayList<>();
        ItemVenda itemVendido;

        for (ItemVenda item : itens) {
            itemVendido = verificarEstoqueERetornarQuantidadeDeItensVendidos(item);
            if (itemVendido.getQuantidade() > 0)
                itensVendidos.add(itemVendido);
        }

        return itensVendidos;
    }

    private ItemVenda verificarEstoqueERetornarQuantidadeDeItensVendidos(ItemVenda item) {
        Long produtoId = item.getProduto().getId();
        Optional<Estoque> optionalEstoque = estoqueRepository.findByProduto_Id(produtoId);

        int quantidadeDeItem = item.getQuantidade();

        if (optionalEstoque.isPresent() && optionalEstoque.get().getQuantidade() != 0) {
            Estoque estoque = optionalEstoque.get();
            int quantidadeEstoque = estoque.getQuantidade();

            if (quantidadeEstoque > item.getQuantidade()) {
                estoque.setQuantidade(quantidadeEstoque - quantidadeDeItem);
            } else {
                estoque.setQuantidade(0);
                item.setQuantidade(quantidadeEstoque);
            }
            estoqueRepository.save(estoque);
            item.setLucroPorItem(calcularLucro(item, estoque));
        } else {
            item.setQuantidade(0);
        }

        return item;
    }

    private BigDecimal calcularLucro(ItemVenda itemVenda, Estoque estoque) {
        List<ItemCompra> listaDeItens = itemCompraService.buscarItensProdutoPeloProdutoEMaioresQueZero(estoque.getProduto());
        int contador = 0;
        BigDecimal precoTotalDaCompraDosItens = new BigDecimal("0.0");

        for(ItemCompra itemCompra: listaDeItens){
            int quantidade = itemCompra.getQuantidadeDeItensDisponiveisParaVenda();
            do{
                contador++;
                quantidade--;
                precoTotalDaCompraDosItens.add(itemCompra.getValorCompra());
            } while (contador < itemVenda.getQuantidade() &&  quantidade > 0);

            itemCompra.setQuantidadeDeItensDisponiveisParaVenda(quantidade);
            itemCompraService.salvarItemCompra(itemCompra);

            if(contador == itemVenda.getQuantidade())
                break;
        }
        BigDecimal valorTotalItem = itemVenda.getValorVenda().multiply(BigDecimal.valueOf(itemVenda.getQuantidade()));
        return valorTotalItem.subtract(precoTotalDaCompraDosItens);
    }

}
