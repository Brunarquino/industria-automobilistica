package br.com.gft.dto.estoqueDTO;

import br.com.gft.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaEstoqueDTO {

    private Long id;
    private Produto produto;
    private int quantidade;

}
