package br.com.gft.dto.itemCompraDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroItemCompraDTO {

    private Long produto_id;
    private int quantidade;
    private BigDecimal valor;
}
