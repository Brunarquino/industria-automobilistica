package br.com.gft.services;

import br.com.gft.entities.*;
import br.com.gft.exceptions.EntityNotFoundException;
import br.com.gft.repositories.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class CompraService {

    private final CompraRepository compraRepository;
    private final FornecedorService fornecedorService;
    private final ItemCompraService itemCompraService;


    public Compra salvarCompra(Compra compra){
        compra.setItens(itemCompraService.buscarInformacoesDoProduto(compra));
        compra.setFornecedor(fornecedorService.buscarFornecedorPorId(compra.getFornecedor().getId()));
        compra.setValorTotal(calcularValorTotalDeCompra(compra.getItens()));

        return compraRepository.save(compra);
    }

    public BigDecimal calcularValorTotalDeCompra(List<ItemCompra> itens){
        BigDecimal valorTotal = new BigDecimal("0.0");
        for(ItemCompra iten: itens) {
            valorTotal = valorTotal.add(valorItens(iten));
        }
        return valorTotal;
    }

    private static BigDecimal valorItens(ItemCompra iten) {
        return new BigDecimal(String.valueOf(iten.getValorCompra()))
                .multiply(new BigDecimal(String.valueOf(iten.getQuantidade())));
    }

    public Page<Compra> listarTodosAsCompras(Pageable pageable){
        return compraRepository.findAll(pageable);
    }


    public Compra buscarCompraPorId(Long id) {
        return compraRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Compra não encontrada"));
    }

}
