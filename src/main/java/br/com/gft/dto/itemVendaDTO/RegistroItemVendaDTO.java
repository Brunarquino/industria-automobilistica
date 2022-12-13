package br.com.gft.dto.itemVendaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroItemVendaDTO {


    private Long produto_id;
    private int quantidade;
    private BigDecimal valor;






}
