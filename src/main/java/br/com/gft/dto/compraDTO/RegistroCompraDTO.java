package br.com.gft.dto.compraDTO;


import br.com.gft.dto.itemCompraDTO.RegistroItemCompraDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCompraDTO {


    private Long fornecedorId;
    private List<RegistroItemCompraDTO> itens;
}
