package br.com.gft.dto.pecaDTO;

import br.com.gft.dto.fornecedorDTO.ConsultaFornecedorDTO;
import br.com.gft.entities.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaPecaDTO {

    private Long produto_id;
    private String nome;



}
