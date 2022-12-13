package br.com.gft.dto.enderecoDTO;

import br.com.gft.entities.Endereco;

public class EnderecoMapper {
	
	public static Endereco fromDTO(EnderecoDTO dto) {
		return new Endereco(dto.getCep(), dto.getUf(), dto.getCidade(),
				dto.getBairro(), dto.getLogradouro(), dto.getNumero(), dto.getComplemento());
	
	}
	
	public static EnderecoDTO fromEntity(Endereco endereco) {
		return new EnderecoDTO(endereco.getCep(), endereco.getUf(),
				endereco.getCidade(), endereco.getBairro(), endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento());
	}

}
