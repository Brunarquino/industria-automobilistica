package br.com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "tb_compra")
public class Compra extends Pedido{

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "compra_id")
    private List<ItemCompra> itens;
    @OneToOne
    private Fornecedor fornecedor;

    public Compra(Long id, BigDecimal valorTotal, List<ItemCompra> itens, Fornecedor fornecedor) {
        super(id, valorTotal);
        this.itens = itens;
        this.fornecedor = fornecedor;
    }
}
