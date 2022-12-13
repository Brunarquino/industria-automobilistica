package br.com.gft.dto.itemVendaDTO;

import br.com.gft.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaItemVendaDTO {

    private Long id;
    private Produto produto_id;
    private int quantidade;


}
