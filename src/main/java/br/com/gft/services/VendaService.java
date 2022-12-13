package br.com.gft.services;

import br.com.gft.entities.*;
import br.com.gft.exceptions.EntityNotFoundException;
import br.com.gft.repositories.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteService clienteService;
    private final ItemVendaService itemVendaService;
    private final CompraService compraService;
    private final EstoqueService estoqueService;
    private final NotaFiscalService notaFiscalService;
    private final FornecedorService fornecedorService;

    public NotaFiscal salvarVenda(Venda venda) {

        venda.setItens(itemVendaService.buscarInformacoesDoProduto(venda));
        venda.setCliente(clienteService.buscarClientePorId(venda.getCliente().getId()));
        venda.setValorTotal(calcularValorTotalDeVenda(venda.getItens()));
        List<ItemVenda> listaDeItensVendido = estoqueService.atualizarEstoqueVenda(venda.getItens());

        if(!listaDeItensVendido.isEmpty()) {
            venda.setLucroPorVenda(calcularLucroDeVenda(listaDeItensVendido));
            Venda vendaRegistrada = vendaRepository.save(venda);
            return gerarNotaFiscalDaVenda(vendaRegistrada, listaDeItensVendido);
        } else {
            vendaRepository.save(venda);
            throw new EntityNotFoundException("Não existe estoque de nenhum produto do pedido");
        }
    }

    private BigDecimal calcularLucroDeVenda(List<ItemVenda> listaDeItensVendido) {
        BigDecimal lucroDaVenda = new BigDecimal("0.0");

        for(ItemVenda item: listaDeItensVendido) {

            lucroDaVenda = lucroDaVenda.add(item.getLucroPorItem());
        }

        return lucroDaVenda;
    }

    private NotaFiscal gerarNotaFiscalDaVenda(Venda venda, List<ItemVenda> listaDeItensVendido) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(1L);
        venda.setValorTotal(calcularValorTotalDeVenda(listaDeItensVendido));
        NotaFiscal notaFiscal = new NotaFiscal(null, venda.getCliente(), fornecedor, listaDeItensVendido,
                venda.getValorTotal());

        return notaFiscalService.salvarNotaFiscal(notaFiscal);
    }

    public BigDecimal calcularValorTotalDeVenda(List<ItemVenda> itens) {
        BigDecimal valorTotal = new BigDecimal("0.0");
        BigDecimal valorItem;

        for(ItemVenda iten: itens) {
            valorItem = new BigDecimal(String.valueOf(iten.getValorVenda()))
                    .multiply(new BigDecimal(String.valueOf(iten.getQuantidade())));
            valorTotal = valorTotal.add(valorItem);
        }

        return valorTotal;
    }

    public Page<Venda> listarTodosAsVendas(Pageable pageable){
        return vendaRepository.findAll(pageable);
    }

    public Venda buscarVendaPorId(Long id) {
        return vendaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Venda não encontrada"));
    }

    public BigDecimal calcularSomatorioDeVendas(){
        List<Venda> vendas = vendaRepository.findAll();
        BigDecimal valorTotalVendas = new BigDecimal("0.0");

        for(Venda venda: vendas){
            valorTotalVendas = valorTotalVendas.add(venda.getValorTotal());
        }

        return valorTotalVendas;
    }

    public BigDecimal calcularValorLucroPorVendas(){
        List<Venda> vendas = vendaRepository.findAll();
        BigDecimal lucroTotalDeVendas = new BigDecimal("0.0");

        for(Venda venda: vendas){
            lucroTotalDeVendas = lucroTotalDeVendas.add(venda.getLucroPorVenda());
        }
        return lucroTotalDeVendas;
    }

}
