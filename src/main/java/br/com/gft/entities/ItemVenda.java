package br.com.gft.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "tb_item_venda")
public class ItemVenda extends Item{
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;
    @Column(name = "lucro_por_item")
    private BigDecimal lucroPorItem;
    @ManyToOne
    private Venda venda;

    public ItemVenda(Long id, Produto produto, int quantidade, BigDecimal valorVenda, BigDecimal lucroPorItem) {
        super(id, produto, quantidade);
        this.valorVenda = valorVenda;
        this.lucroPorItem = lucroPorItem;
    }

}
