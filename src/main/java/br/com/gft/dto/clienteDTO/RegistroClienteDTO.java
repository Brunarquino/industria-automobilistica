package br.com.gft.dto.clienteDTO;

import br.com.gft.dto.enderecoDTO.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class RegistroClienteDTO {
	

	 private String nome;
	 private String cpf;
	 private EnderecoDTO endereco;
}
