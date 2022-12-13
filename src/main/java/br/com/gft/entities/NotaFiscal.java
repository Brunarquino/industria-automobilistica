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
@Table(name = "tb_nota")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Fornecedor fornecedor;
    @OneToMany
    @JoinTable(name = "tb_nota_item" ,
            joinColumns = @JoinColumn(name = "nota_id"),inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemVenda> itens;
    @Column(name="valor_total")
    private BigDecimal valorTotal;

}
