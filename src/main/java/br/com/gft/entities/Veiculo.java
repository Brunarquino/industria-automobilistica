package br.com.gft.entities;

import br.com.gft.enuns.StatusVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "tb_produto_veiculo")
@Entity
public class Veiculo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id", referencedColumnName = "produto_id")
    private Produto produto;
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;
    private BigDecimal valorInsumo;
    @ManyToMany
    @JoinTable(name = "tb_veiculos_pecas" ,
       joinColumns = @JoinColumn(name = "veiculo_id"),inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<Peca> pecas;

}
