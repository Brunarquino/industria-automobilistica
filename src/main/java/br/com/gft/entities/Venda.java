package br.com.gft.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "tb_venda")
public class Venda extends Pedido{

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itens;
    @OneToOne
    private Cliente cliente;
    @Column(name = "lucro_por_venda")
    private BigDecimal lucroPorVenda;

    public Venda(Long id, BigDecimal valorTotal, List<ItemVenda> itens, Cliente cliente) {
        super(id, valorTotal);
        this.itens = itens;
        this.cliente = cliente;
        this.lucroPorVenda = new BigDecimal("0.0");
    }

}
