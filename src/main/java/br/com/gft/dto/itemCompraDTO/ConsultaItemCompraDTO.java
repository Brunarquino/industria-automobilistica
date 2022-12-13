package br.com.gft.dto.itemCompraDTO;

import br.com.gft.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaItemCompraDTO {

    private Long id;
    private Produto produto_id;
    private int quantidade;
}
