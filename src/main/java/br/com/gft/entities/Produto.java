package br.com.gft.entities;

import br.com.gft.enuns.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;
    private String nome;

    public Produto(Long id) {
        this.id = id;
    }

}
