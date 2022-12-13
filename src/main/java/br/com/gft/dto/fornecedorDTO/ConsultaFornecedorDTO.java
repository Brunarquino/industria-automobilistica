package br.com.gft.dto.fornecedorDTO;


import br.com.gft.dto.enderecoDTO.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaFornecedorDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String nacionalidade;
    private int pontuacao;
    private EnderecoDTO endereco;
}


