package br.com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "tb_item_compra")
public class ItemCompra  extends Item{

    private BigDecimal valorCompra;
    @Column(name = "quantidade_de_itens_disponiveis_para_venda")
    private int quantidadeDeItensDisponiveisParaVenda;
    @ManyToOne
    private Compra compra;

    public ItemCompra(Long id, Produto produto, int quantidade, BigDecimal valorCompra,
                      int quantidadeDeItensDisponiveisParaVenda) {
        super(id, produto, quantidade);
        this.valorCompra = valorCompra;
        this.quantidadeDeItensDisponiveisParaVenda = quantidadeDeItensDisponiveisParaVenda;
    }
}
